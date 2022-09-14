package job;

import dao.Coupon.CouponsDAO;
import dao.Coupon.CouponsDBDAO;

// todo Checking
public class CouponExpirationDailyJob implements Runnable {
    private CouponsDAO couponsDAO = new CouponsDBDAO();
    private boolean quit = false;
    private static final int Day = 1000 * 60 * 60 * 24;
    private static CouponExpirationDailyJob instance = null;

    private CouponExpirationDailyJob() {
    }

    public static CouponExpirationDailyJob getInstance() {
        if (instance == null) {
            synchronized (CouponExpirationDailyJob.class) {
                if (instance == null) instance = new CouponExpirationDailyJob();
            }
        }
        return instance;
    }

    @Override
    public void run() {
        while (!quit) {
            try {
                couponsDAO.ExCoupon();
                Thread.sleep(Day);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void stop() {
        quit = true;
    }
}
