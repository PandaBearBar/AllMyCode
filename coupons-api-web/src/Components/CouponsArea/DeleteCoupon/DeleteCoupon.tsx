import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import store from "../../../Redux/Store";
import { CouponDeletedAction } from "../../../Redux/CouponsAppState";
import web from "../../../Services/WebApi";
import "./DeleteCoupon.css";
import notify, { SccMsg } from "../../../Services/Notifications";

function DeleteCoupon(): JSX.Element {

    const navigate = useNavigate();
    const params = useParams();
    const couponId = +(params.id || 0);

    const [id, setId] = useState<number>(couponId);


    const no = () => {
        navigate('/coupons');
    }

    const yes = () => {
        web.deleteCoupon(id)
            .then(res => {
                notify.success(SccMsg.DELETE_COUPONS);
                navigate('/coupons');
                store.dispatch(CouponDeletedAction(id));
            })
            .catch(err => {
                notify.error('Could not delete coupon');
                navigate('/coupons');
            });

    }

    return (
        <div className="DeleteCoupon flex-center-col">
            <h1>Delete Coupon</h1>
            <h3>Are you sure you want to delete coupon #{id}?</h3>
            <div className="flex-row">
               
                <button className="button-danger" onClick={yes} >YES</button>
                <button className="button" onClick={no}>NO</button>
            </div>
        </div>
    );
}

export default DeleteCoupon;