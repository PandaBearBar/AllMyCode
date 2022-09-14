import "./AddCoupon.css";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { useNavigate } from "react-router-dom";
import web from "../../../Services/WebApi";
import store from "../../../Redux/Store";
import { CouponPayloadModel } from "../../../Models/CouponModel";
import notify, { SccMsg } from "../../../Services/Notifications";
import { CouponAddedAction } from "../../../Redux/CouponsAppState";
function AddCoupon(): JSX.Element {


    const navigate = useNavigate();

    const schema = yup.object().shape({
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

    const { register, handleSubmit, formState: { errors, isDirty, isValid } } =
        useForm<CouponPayloadModel>({ mode: "all", resolver: yupResolver(schema) });

    const add = async (coupon: CouponPayloadModel) => {

        console.log(coupon);
        console.log(JSON.stringify(coupon));

       web.addCoupon(coupon)
            .then(res => { 
                notify.success(SccMsg.ADD_COUPONS);
                navigate('/coupons');
                store.dispatch(CouponAddedAction(res.data));
                
            })
            .catch(err => { 
                notify.error('error: could not add coupon' );
                navigate('/coupons');
            });
    }

    return (
        <div className="AddCoupon flex-center-col">
            <h1>Add Coupon</h1>
            <form onSubmit={handleSubmit(add)} className="flex-center-col">
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
                <button className="button-success" disabled={!isValid}>Add</button>
            </form>
        </div>
    );
}

export default AddCoupon;