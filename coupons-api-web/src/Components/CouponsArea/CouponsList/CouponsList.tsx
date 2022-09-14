import { useEffect, useState } from "react";
import { FaPlus } from "react-icons/fa";
import "./CouponsList.css";
import web from "../../../Services/WebApi";
import store from "../../../Redux/Store";
import CustomLink from "../../RoutingArea/CustomLink/CustomLink";
import { CouponModel } from "../../../Models/CouponModel";
import notify, { SccMsg } from "../../../Services/Notifications";
import { CouponsDownloadedAction } from "../../../Redux/CouponsAppState";
import EmptyView from "../../SharedArea/EmptyView/EmptyView";
import CouponItem from "../CouponItem/CouponItem";

function CouponsList(): JSX.Element {

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
                    notify.error('Error loading coupons');
                });
        }
    }, [coupons]);

    return (
        <div className="CouponsList flex-center-col">
            <h2>Coupons List</h2>
            <CustomLink to="add"><FaPlus size={56} /></CustomLink>
            <div className="flex-row-none-wrap-list">
                {
                    (coupons.length > 0)
                        ?
                        coupons.map(t => <CouponItem key={t.id} coupon={t} />)
                        :
                        <EmptyView msg='No Coupons Found' />
                }
            </div>
        </div>
    );
}

export default CouponsList;