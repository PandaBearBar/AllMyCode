import { useEffect, useState } from "react";
import store from "../../../Redux/Store";
import notify, { SccMsg } from "../../../Services/Notifications";
import web from "../../../Services/WebApi";
import Circle from "../../SharedArea/Circle/Circle";
import "./CouponsTotal.css";

function CouponsTotal(): JSX.Element {

    const [num, setNum] = useState(store.getState().couponsReducer.Coupons.length);

    useEffect(() => {
        if (num === 0) {
            web.countCoupons()
                .then(res => {
                    setNum(res.data);
                    notify.successStr(SccMsg.TOTAL_COUPONS + res.data);
                })
                .catch(err => notify.error(err.message));
        }
        return store.subscribe(() => {
            setNum(store.getState().couponsReducer.Coupons.length);
        });
    }, [num]);






    return (
        <div className="CouponsTotal">
            <Circle num={num}></Circle>
        </div>
    );
}

export default CouponsTotal;