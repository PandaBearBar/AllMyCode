import CouponsList from "../../CouponsArea/CouponsList/CouponsList";
import "./CompanyCoupons.css";

function CompanyCoupons(): JSX.Element {
    return (
        <div className="Coupons flex-center-col">
			<CouponsList />
        </div>
    );
}

export default CompanyCoupons;