import "./Login.css";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import {LoginModel } from "../../../Models/Welcome";
import web from "../../../Services/WebApi";
import { useNavigate } from "react-router-dom";
import store from "../../../Redux/Store";
import { loginAction } from "../../../Redux/UserAppState";
import notify, { SccMsg } from "../../../Services/Notifications";
function Login(): JSX.Element {

    const navigate = useNavigate();

    const schema = yup.object().shape({
        email:
            yup.string()
                .email("Invalid Email Pattern")
                .required("Email is required"),
        password:
            yup.string()
                .required("Password is required")
                .min(3, "at least 3 characters required")
                .max(12, "at most 12 characters allowed")
    });

    const { register, handleSubmit, formState: { errors, isDirty, isValid } } =
        useForm<LoginModel>({ mode: "all", resolver: yupResolver(schema) });



    const loginUser = async (model: LoginModel) => {
        const credentials = new LoginModel();
        credentials.email = model.email;
        credentials.password = model.password;
        credentials.userType = model.userType;

        web.login(credentials)
            .then((res) => {
                notify.success(SccMsg.LOGIN_SUCCESS);
                store.dispatch(loginAction(res.data));
                localStorage.setItem('email', credentials.email || '');
                localStorage.setItem('type', credentials.userType || '');
                navigate('/home');
            })
            .catch(err => {
                notify.error('Login credentials are incorrect');
            });
    }

    return (
        <div className="Login flex-center-col">
            <h1>Login</h1>
            <form onSubmit={handleSubmit(loginUser)} className="flex-center-col">
                <label htmlFor="email">Email</label>
                <input {...register("email")} type="email" placeholder="email" id="email" />
                <span>{errors.email?.message}</span>
                <label htmlFor="password">Password</label>
                <input  {...register("password")} type="password" placeholder="password" id="password" />
                <span>{errors.password?.message}</span>
                <label id="userType">
                Login as:
                <select {...register("userType")} className="custom-select" required>
                            <option value="administrator">Admin</option>
                            <option value="company">Company</option>
                            <option value="customer">Customer</option>
                        </select>
                </label>
                <button className="button-success" disabled={!isValid}>Login</button>
            </form>
        </div>
    );
}

export default Login;