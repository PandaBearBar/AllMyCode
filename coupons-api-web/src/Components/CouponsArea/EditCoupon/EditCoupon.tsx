import "./EditCoupon.css";
import { useForm, useFormState } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { CouponModel, CouponPayloadModel } from "../../../Models/CouponModel";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import web from "../../../Services/WebApi";
import store from "../../../Redux/Store";
import { CouponUpdatedAction } from "../../../Redux/CouponsAppState";
import notify, { SccMsg } from "../../../Services/Notifications";

interface EditCouponProps { }
function EditCoupon(): JSX.Element {

    const navigate = useNavigate();
    const params = useParams();
    const couponId = +(params.id || 0);


    const [id, setId] = useState<number>(couponId);
    const [coupon, setCoupons] = useState<CouponModel>(store.getState().couponsReducer.Coupons.filter(t => t.id === id)[0]);
    const [origin, setOrigin] = useState<CouponPayloadModel>({ 'category': coupon.category, 'title': coupon.title, 'description': coupon.description, 'startDate': coupon.startDate, 'endDate': coupon.endDate, 'amount': coupon.amount, 'price': coupon.price, 'image': coupon.image})





    // Step 6 - Manage Your schema
    const schema = yup.object().shape({
        category:
            yup.string()
                .required("Caption is required"),
        title:
            yup.string()
                .required("title is required"),
        description:
            yup.string()
                .required("description is required"),
        startDate:
             yup.date()
                 .min(new Date(), 'Coupon cannot start on past date')
                 .default(new Date())
                 .typeError("You must specify a due date")
                 .required("start date is required")
                 .nullable().default(() => new Date()),
        endDate:
                 yup.date()
                     .min(new Date(), 'Coupon cannot end on past date')
                     .default(new Date())
                     .typeError("You must specify a due date")
                     .required("end date is required")
                     .nullable().default(() => new Date()),
        amount:
            yup.number()
                .min(1, 'amount must be greater than 0')
                .required("amount is required")
                .typeError("amount is required"),
        price:
            yup.number()
                .min(1, 'price must be greater than 0')
                .typeError("price is required")
                .required("price is required"),
        image:
            yup.string()
            .default('https://ps.w.org/wp-coupons-and-deals/assets/icon-256x256.png?rev=1974447')

    });

    // Step 7 - Prepare the Hook
    let defaultValuesObj = { ...origin };

    const { register, handleSubmit, control, formState: { errors, isDirty, isValid } }
        = useForm<CouponPayloadModel>({ defaultValues: defaultValuesObj, mode: "all", resolver: yupResolver(schema) });

    const { dirtyFields } = useFormState({ control });

    const yalla = async (todo: CouponPayloadModel) => {

        web.editCoupon(id, todo)
            .then(res => {
                notify.success(SccMsg.UPDATE_COUPONS);
                navigate('/coupons');
                store.dispatch(CouponUpdatedAction(res.data));
            })
            .catch(err => { notify.error('Error : update failed') });
    }


    return (
        <div className="EditCoupon flex-center-col">
            <h1>Update Coupon</h1>
            <form onSubmit={handleSubmit(yalla)} className="flex-center-col">
            <label id="category">
                Category:
                <select {...register("category")} className="custom-select" required>
                            <option value="Food">Food</option>
                            <option value="Electricity">Electricity</option>
                            <option value="Restaurant">Restaurant</option>
                            <option value="Vacation">Vacation</option>
                        </select>
                </label>
                <span>{errors.category?.message}</span>
                <label htmlFor="title">title</label>
                <input  {...register("title")} type="text" placeholder="title" id="title" />
                <span>{errors.title?.message}</span>
                <label htmlFor="description">description</label>
                <input  {...register("description")} type="text" placeholder="description" id="description" />
                <span>{errors.description?.message}</span>
                <label htmlFor="startDate">Start date</label>
                <input  {...register("startDate")} type="date" placeholder="startDate" id="startDate" />
                <span>{errors.startDate?.message}</span>
                <label htmlFor="endDate">End date</label>
                <input  {...register("endDate")} type="date" placeholder="endDate" id="endDate" />
                <span>{errors.endDate?.message}</span>
                <label htmlFor="amount">amount</label>
                <input  {...register("amount")} type="number" placeholder="amount" id="amount" />
                <span>{errors.amount?.message}</span>
                <label htmlFor="price">price</label>
                <input  {...register("price")} type="number" placeholder="price" id="price" />
                <span>{errors.price?.message}</span>
                <label htmlFor="image">image url</label>
                <input  {...register("image")} type="text" placeholder="image" id="image" />
                <span>{errors.image?.message}</span>
                <button className="button-success" disabled={!isValid}>Update</button>
            </form>
        </div>
    );
}

export default EditCoupon;