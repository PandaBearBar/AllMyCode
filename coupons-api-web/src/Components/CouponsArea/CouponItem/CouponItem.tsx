import moment from "moment";
import "./CouponItem.css";
import CustomLink from "../../RoutingArea/CustomLink/CustomLink";
import { MdDelete, MdModeEdit } from "react-icons/md";
import { CouponModel } from "../../../Models/CouponModel";
interface CouponItemProps {
    coupon: CouponModel;
}

function CouponItem(props: CouponItemProps): JSX.Element {
    return (
        <div className="CouponItem">
            <h2 className="single-line-only">{props.coupon.title}</h2>
            <div className="card">
                <img src={props.coupon.image} alt={props.coupon.title} />
                <span>{props.coupon.category}</span>
                <span>{props.coupon.companyName}</span>
                <p className="single-line-only">{props.coupon.description}</p>
                <span className="date">{moment(props.coupon.endDate).format("DD/MM/yyyy")}</span>
                <p>{props.coupon.amount} Left!</p>
                <p>{props.coupon.price}₪</p>
                <div className="flex-around">
                    <CustomLink to={`delete/${props.coupon.id}`}><MdDelete size={42} color="red"/></CustomLink>
                    <CustomLink to={`update/${props.coupon.id}`}><MdModeEdit size={42} color="black"/></CustomLink>
                </div>
            </div>
        </div>
    );
}

export default CouponItem;