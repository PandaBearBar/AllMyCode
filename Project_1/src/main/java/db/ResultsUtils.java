package db;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;

import java.sql.Date;
import java.util.HashMap;

public class ResultsUtils {
    public static boolean fromHashMapToBool(HashMap<String, Object> row) {
        return ((long) row.get("res")) == 1;
    }

    public static Company fromHashMapToCompany(HashMap<String, Object> row) {
        int id = (int) row.get("Id");
        String Name = (String) row.get("Name");
        String Email = (String) row.get("Email");
        String Password = (String) row.get("Password");

        return new Company(id, Name, Email, Password);
    }

    public static Customer fromHashMapToCustomer(HashMap<String, Object> row) {
        int id = (int) row.get("Id");
        String First_Name = (String) row.get("First_Name");
        String Last_Name = (String) row.get("Last_Name");
        String Email = (String) row.get("Email");
        String Password = (String) row.get("Password");

        return new Customer(id, First_Name, Last_Name, Email, Password);
    }

    public static Coupon fromHashMapToCoupon(HashMap<String, Object> row) {
        int Id = (int) row.get("Id");
        int company_Id = (int) row.get("Company_Id");
        int category_Id = (int) row.get("Category_Id");
        String title = (String) row.get("Title");
        String description = (String) row.get("Description");
        Date start_Date = (Date) row.get("Start_Date");
        Date end_Date = (Date) row.get("End_Date");
        int amount = (int) row.get("Amount");
        double price = (double) row.get("Price");
        String image = (String) row.get("Image");


        return new Coupon(Id, company_Id, Category.values()[category_Id - 1], title, description, start_Date, end_Date, amount, price, image);
    }


    public static Integer fromHashMapToCouponId(HashMap<String, Object> row) {
        return (int) row.get("Coupon_Id");
    }
}
