package Utils;

import java.time.LocalDate;

public class DateUtil {
    public static String beautifyDate(LocalDate date) {
        return String.format("%02d/%02d/%4d",date.getDayOfMonth(),date.getMonthValue(),date.getYear());
    }


}
