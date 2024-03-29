package com.project.project2.repository;

import com.project.project2.bins.Category;
import com.project.project2.bins.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO project2.customers_coupons(customer_id,coupons_id) VALUES (:customerId, :couponsId);"
    )
    void addCouponPurchase(@Param("customerId") int customerId, @Param("couponsId") int couponsId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM project2.customers_coupons where (customer_id = :customerId and coupons_id = :couponsId);"
    )
    void deleteCouponPurchase(@Param("customerId") int customerId, @Param("couponsId") int couponsId);

    @Query(nativeQuery = true,
            value = "select exists (select * FROM project2.customers_coupons where coupons_id = :couponsId and customer_id = :customerId ) as res;"
    )
    Integer exitsByCustomerIdAndCouponsId(@Param("customerId") int customerId, @Param("couponsId") int couponsId);

    boolean existsByCompanyIdAndTitle(int companyId, String title);

    boolean existsByCompanyIdAndId(int companyId, int id);

    Coupon findByCompanyIdAndId(int companyId, int id);

    List<Coupon> findAllByCompanyId(int companyId);

    List<Coupon> findAllByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findAllByCompanyIdAndPriceLessThanEqual(int companyId, double maxPrice);

    @Query(nativeQuery = true,
            value = "SELECT coupons.*\n" +
                    "FROM project2.customers_coupons\n" +
                    "INNER JOIN project2.coupons\n" +
                    "ON customers_coupons.coupons_id = coupons.id and customers_coupons.customer_id = :customerId ")
    List<Coupon> findAllByCustomerId(@Param("customerId") int customerId);

    @Query(nativeQuery = true,
            value = "SELECT coupons.*\n" +
                    "FROM project2.customers_coupons\n" +
                    "INNER JOIN project2.coupons\n" +
                    "ON customers_coupons.coupons_id = coupons.id and customers_coupons.customer_id = :customerId and category = :category ")
    List<Coupon> findAllByCustomerIdAndCategory(@Param("customerId") int customerId, @Param("category") Category category);

    @Query(nativeQuery = true,
            value = "SELECT coupons.*\n" +
                    "FROM project2.customers_coupons\n" +
                    "INNER JOIN project2.coupons\n" +
                    "ON customers_coupons.coupons_id = coupons.id and customers_coupons.customer_id = :customerId and price <= :price ")
    List<Coupon> findAllByCustomerIdAndPriceLessThanEqual(@Param("customerId") int customerId, @Param("price") double maxPrice);

    @Transactional
    void deleteAllByEndDateLessThan(Date endDate);
}
