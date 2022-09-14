import { Route, Routes } from "react-router-dom";
import App from "../../../App";
import About from "../../PagesArea/About/About";
import Home from "../../PagesArea/Home/Home";
import Page404 from "../Page404/Page404";
import "./Routing.css";
import Login from "../../AuthArea/Login/Login";
import RegisterCustomer from "../../AuthArea/Register/RegisterCustomer";
import Logout from "../../AuthArea/Logout/Logout";
import AddCoupon from "../../CouponsArea/AddCoupon/AddCoupon";
import RegisterCompany from "../../AuthArea/Register/RegisterCompany";
import DeleteCoupon from "../../CouponsArea/DeleteCoupon/DeleteCoupon";
import EditCoupon from "../../CouponsArea/EditCoupon/EditCoupon";
import CustomerCoupons from "../../PagesArea/CustomerCoupons/CustomerCoupons";
import CompanyCoupons from "../../PagesArea/CompanyCoupons/CompanyCoupons";
import PurchaseCoupon from "../../CustomerCouponArea/PurchaseCoupon/PurchaseCoupon";

function Routing(): JSX.Element {
    return (
        <div className="Routing">
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/home" element={<Home />} />
                <Route index element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/coupons" element={localStorage.getItem('type') === 'company' || localStorage.getItem('type') === 'administrator'  ? <CompanyCoupons /> : <CustomerCoupons/>} />
                <Route path="/coupons/purchase/:id" element={<PurchaseCoupon />} />
                <Route path="coupons/add" element={<AddCoupon />} />
                <Route path="coupons/update/:id" element={<EditCoupon />} />
                <Route path="coupons/delete/:id/" element={<DeleteCoupon />} />
                <Route path="login" element={<Login />} />
                <Route path="register/company" element={<RegisterCompany />} />
                <Route path="register/customer" element={<RegisterCustomer />} />
                <Route path="logout" element={<Logout />} />
                <Route path="*" element={<Page404 />} />

            </Routes>
        </div>
    );
}

export default Routing;