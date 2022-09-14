import "./RegisterCompany.css";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { CompanyCredentialsModel, CompanyRegisterModel } from "../../../Models/Welcome";
import web from "../../../Services/WebApi";
import { useNavigate } from "react-router-dom";
import notify, { SccMsg } from "../../../Services/Notifications";
import {CompanyRegisterPayloadModel } from "../../../Models/CompanyModel";
function RegisterCompany(): JSX.Element {

    const navigate = useNavigate();

    const schema = yup.object().shape({
        name:
            yup.string()
                .min(3, "at least 3 characters required")
                .max(20, "at most 20 characters required")
                .required("name is required"),
        email:
            yup.string()
                .email("Invalid Email Pattern")
                .required("Email is required"),
        password:
            yup.string()
                .min(3, "at least 3 characters required")
                .max(12, "at most 12 characters allowed")
                .required("Password is required"),
        confirm:
            yup.string()
                .test('passwords-match', 'Passwords must match', function (value) {
                    return this.parent.password === value
                })

    });

    const { register, handleSubmit, formState: { errors, isDirty, isValid } } =
        useForm<CompanyRegisterPayloadModel>({ mode: "all", resolver: yupResolver(schema) });


    const registerCompany = async (model: CompanyRegisterModel) => {
        const credentials = new CompanyCredentialsModel();
        credentials.name = model.name;
        credentials.email = model.email;
        credentials.password = model.password;

        console.log('going to send to remote server...' + credentials);

        web.registerCompany(credentials)
            .then((res) => {
                notify.success(SccMsg.REGISTER_SUCCESS);
                navigate('/login');

            })
            .catch(err => {
                console.log(err);
                notify.error(err.value);
            });
    }


    return (
        <div className="Register flex-center-col">
            <h1>Register Company</h1>
            <form onSubmit={handleSubmit(registerCompany)} className="flex-center-col">
                <label htmlFor="name">Company Name</label>
                <input {...register("name")} type="text" placeholder="name" id="name" />
                <span>{errors.name?.message}</span>
                <label htmlFor="email">Email</label>
                <input {...register("email")} type="email" placeholder="email" id="email" />
                <span>{errors.email?.message}</span>
                <label htmlFor="password">Password</label>
                <input  {...register("password")} type="password" placeholder="password" id="password" />
                <span>{errors.password?.message}</span>
                <label htmlFor="confirm">Confirm Password</label>
                <input  {...register("confirm")} type="password" placeholder="confirm" id="confirm" />
                <span>{errors.confirm?.message}</span>
                <button className="button-success" disabled={!isValid}>Register Company</button>
            </form>
        </div>
    );
}

export default RegisterCompany;