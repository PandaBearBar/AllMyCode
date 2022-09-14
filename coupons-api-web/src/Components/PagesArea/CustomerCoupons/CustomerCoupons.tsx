import CustomerCouponsList from "../../CustomerCouponArea/CouponsList/CustomerCouponsList";
import "./CustomerCoupons.css";

function CustomerCoupons(): JSX.Element {
    return (
        <div className="CustomerCoupons flex-center-col">
			<CustomerCouponsList />
        </div>
    );
}

export default CustomerCoupons;