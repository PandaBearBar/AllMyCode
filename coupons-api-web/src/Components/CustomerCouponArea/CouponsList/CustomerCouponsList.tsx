import { useEffect, useState } from "react";
import "./CustomerCouponsList.css";
import { CouponModel } from "../../../Models/CouponModel";
import { CouponsDownloadedAction } from "../../../Redux/CouponsAppState";
import store from "../../../Redux/Store";
import notify, { SccMsg } from "../../../Services/Notifications";
import web from "../../../Services/WebApi";
import EmptyView from "../../SharedArea/EmptyView/EmptyView";
import CustomerCouponItem from "../CouponItem/CustomerCouponItem";

function CustomerCouponsList(): JSX.Element {

    const [coupons, setCoupons] = useState<CouponModel[]>(store.getState().couponsReducer.Coupons);

    useEffect(() => {
        if (store.getState().couponsReducer.Coupons.length === 0) {
            web.getAllCoupons()
                .then((res) => {
                    notify.success(SccMsg.ALL_COUPONS);
                    setCoupons(res.data);
                    store.dispatch(CouponsDownloadedAction(coupons));
                })
                .catch((err) => {
                    notify.error('Could not get coupons');
                });
        }
    }, [coupons]);

    return (
        <div className="CouponsList flex-center-col">
            <h2>Coupons List</h2>
            <div className="flex-row-none-wrap-list">
                {
                    (coupons.length > 0)
                        ?
                        coupons.map(t => <CustomerCouponItem key={t.id} coupon={t} />)                        :
                        <EmptyView msg='No Coupons Found' />
                }
            </div>
        </div>
    );
}

export default CustomerCouponsList;