import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import store from "../../../Redux/Store";
import { CouponsClear } from "../../../Redux/CouponsAppState";
import { logoutAction } from "../../../Redux/UserAppState";
import "./Logout.css";

function Logout(): JSX.Element {

    const navigate = useNavigate();

    useEffect(() => {
        const res = window.confirm('Are you sure you want to log out?');
        if (res) {
            store.dispatch(logoutAction());
            store.dispatch(CouponsClear());
            localStorage.setItem('type', '');
            navigate("/login");
        }

    })
    return (
        <>

        </>
    );
}

export default Logout;