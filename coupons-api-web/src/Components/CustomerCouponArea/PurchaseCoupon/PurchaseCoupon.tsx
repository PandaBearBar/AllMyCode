import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import store from "../../../Redux/Store";
import {CouponPurchasedAction } from "../../../Redux/CouponsAppState";
import web from "../../../Services/WebApi";
import "./PurchaseCoupon.css";
import notify, { SccMsg } from "../../../Services/Notifications";

function PurchaseCoupon(): JSX.Element {

    const navigate = useNavigate();
    const params = useParams();
    const couponId = +(params.id || 0);

    const [id, setId] = useState<number>(couponId);


    const no = () => {
        navigate('/coupons');
    }

    const yes = () => {
        if(localStorage.getItem('type') === 'customer')
        {
        web.purchaseCoupon(id)
            .then(res => {
                notify.success(SccMsg.Purchase_COUPONS);
                navigate('/coupons');
                store.dispatch(CouponPurchasedAction(id));
            })
            .catch(err => {
                notify.error("Coupon is either already bought or out of stock!");
                navigate('/coupons');
            });
        }else{
            notify.error('Please Log in')
            navigate('/login');
        }

    }

    return (
        <div className="PurchaseCoupon flex-center-col">
            <h1>Purchase Coupon</h1>
            <h3>Are you sure you want to purchase coupon #{id}?</h3>
            <div className="flex-row">
               
                <button className="button-danger" onClick={yes} >YES</button>
                <button className="button" onClick={no}>NO</button>
            </div>
        </div>
    );
}

export default PurchaseCoupon;