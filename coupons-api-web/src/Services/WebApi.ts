import axios from "axios";
import { CouponModel, CouponPayloadModel } from "../Models/CouponModel";
import { CompanyCredentialsModel, CustomerCredentialsModel, LoginModel, UserModel } from "../Models/Welcome";
import globals from "./globals";
import tokenAxios from "./InterceptorAxios";

class WebApi {
    private couponActionsApi = globals.urls.couponsApi;
    private couponPurchaseApi = globals.urls.couponsPurchaseApi;
    private couponApi = globals.urls.coupons;
    private welcomeApi = globals.urls.welcome;

    public async addCoupon(coupon: CouponPayloadModel): Promise<any> {
        return await tokenAxios.post<CouponModel>(this.couponActionsApi, coupon);
    }

    public async editCoupon(id: number, coupon: CouponPayloadModel): Promise<any> {
        return await tokenAxios.put<any>(this.couponActionsApi + id, coupon);
    }

    public async deleteCoupon(id: number): Promise<any> {
        return await tokenAxios.delete<any>(this.couponActionsApi + id);
    }

    public async purchaseCoupon(id: number): Promise<any> {
        return await tokenAxios.post<any>(this.couponPurchaseApi + id);
    }

    public async getAllCoupons(): Promise<any> {
        return await tokenAxios.get<CouponModel[]>(this.couponApi);
    }

    public async getSingleCoupon(id: number): Promise<any> {
        return await tokenAxios.get<CouponModel>(this.couponApi + id);
    }

    public async countCoupons(): Promise<any> {
        return await tokenAxios.get<number>(this.couponApi + 'count');
    }

    public async registerCompany(credentials: CompanyCredentialsModel): Promise<any> {
        return await axios.post<any>(this.welcomeApi + 'register/company', credentials);
    }

    public async registerCustomer(credentials: CustomerCredentialsModel): Promise<any> {
        return await axios.post<any>(this.welcomeApi + 'register/customer', credentials);
    }

    public async login(credentials: LoginModel): Promise<any> {
        console.log(credentials.userType);
        return await axios.post<UserModel>(this.welcomeApi + `login/${credentials.userType}`, credentials);
    }





}
const web = new WebApi();
export default web;