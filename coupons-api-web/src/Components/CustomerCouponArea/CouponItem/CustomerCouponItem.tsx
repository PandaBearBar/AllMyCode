import moment from "moment";
import "./CustomerCouponItem.css";
import {MdShoppingCart } from "react-icons/md";
import CustomLink from "../../RoutingArea/CustomLink/CustomLink";
import { CouponModel } from "../../../Models/CouponModel";
interface CouponItemProps {
    coupon: CouponModel;
}

function CustomerCouponItem(props: CouponItemProps): JSX.Element {
    return (
        <div className="CouponItem">
            <h2 className="single-line-only">{props.coupon.title}</h2>
            <div className="card">
                <img src={props.coupon.image} alt={props.coupon.title} />
                <span>{props.coupon.category}</span>
                <span>{props.coupon.companyName}</span>
                <p className="single-line-only">{props.coupon.description}</p>
                <span className="date">{moment(props.coupon.endDate).format("DD/MM/yyyy")}</span>
                <p className={props.coupon.amount === 0 ? "OutOfStock" : ""}>{props.coupon.amount} Left!</p>
                <p>{props.coupon.price}₪</p>
                <div className="flex-around">
                    <CustomLink to={`purchase/${props.coupon.id}`}><MdShoppingCart size={42} color="green"/></CustomLink>
                </div>
            </div>
        </div>
    );
}

export default CustomerCouponItem;