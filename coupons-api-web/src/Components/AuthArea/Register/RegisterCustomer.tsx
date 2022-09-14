import "./RegisterCustomer.css";
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { CustomerCredentialsModel, CustomerRegisterModel } from "../../../Models/Welcome";
import web from "../../../Services/WebApi";
import { useNavigate } from "react-router-dom";
import notify, { SccMsg } from "../../../Services/Notifications";
import { CustomerRegisterPayloadModel } from "../../../Models/CustomerModel";
function RegisterCustomer(): JSX.Element {

    const navigate = useNavigate();

    const schema = yup.object().shape({
        firstName:
            yup.string()
                .min(3, "at least 3 characters required")
                .max(20, "at most 20 characters required")
                .required("name is required"),
        lastName:
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
        useForm<CustomerRegisterPayloadModel>({ mode: "all", resolver: yupResolver(schema) });


    const registerCustomer = async (model: CustomerRegisterModel) => {
        const credentials = new CustomerCredentialsModel();
        credentials.firstName = model.firstName;
        credentials.lastName = model.lastName;
        credentials.email = model.email;
        credentials.password = model.password;

        console.log('going to send to remote server...' + credentials);

        web.registerCustomer(credentials)
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
            <h1>Register Customer</h1>
            <form onSubmit={handleSubmit(registerCustomer)} className="flex-center-col">
                <label htmlFor="firstName">First Name</label>
                <input {...register("firstName")} type="text" placeholder="firstName" id="firstName" />
                <span>{errors.firstName?.message}</span>
                <label htmlFor="lastName">Last Name</label>
                <input {...register("lastName")} type="text" placeholder="lastName" id="lastName" />
                <span>{errors.lastName?.message}</span>
                <label htmlFor="email">Email</label>
                <input {...register("email")} type="email" placeholder="email" id="email" />
                <span>{errors.email?.message}</span>
                <label htmlFor="password">Password</label>
                <input  {...register("password")} type="password" placeholder="password" id="password" />
                <span>{errors.password?.message}</span>
                <label htmlFor="confirm">Confirm Password</label>
                <input  {...register("confirm")} type="password" placeholder="confirm" id="confirm" />
                <span>{errors.confirm?.message}</span>
                <button className="button-success" disabled={!isValid}>Register Customer</button>
            </form>
        </div>
    );
}

export default RegisterCustomer;