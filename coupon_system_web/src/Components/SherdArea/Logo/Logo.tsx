import "./Logo.css";
import src from '../../../Assets/Images/discount.png'

function Logo(): JSX.Element {
    return (
        <div className="Logo">
            <h1>CouponAlism</h1>
			<img src={src} alt="logo"/>
        </div>
    );
}

export default Logo;
