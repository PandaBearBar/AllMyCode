package systemException;

public enum ExceptionMSG {
    Company_Exist("The Company Name Is Already Exist..."),
    Email_Exist("The Email Is Already Exist..."),
    Company_Not_Same_Name("Company Name Can't Be Change"),
    Company_Not_Same_ID("Company Code Can't Be Change"),
    Customer_Not_Same_ID("Customer Code Can't Be Change"),
    Coupon_Name_Exist("Coupon name already exist in this company"),
    Coupon_Not_Same_ID("Coupon Code Can't Be Change"),
    Purchase_Coupon_X_Times("Coupon Can't Be Purchase more then once"),
    Purchase_Coupon_END_Amount("This Coupon supply run out ! "),
    Purchase_Coupon_END_Time("This Coupon have end his time ! "),
    Logout("This account is not logged in ..."), Company_NOT_Exist("Company doesn't exist"),
    Purchase_NOT_EXIST("Purchase not exist");
    private final String msg;

    ExceptionMSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
