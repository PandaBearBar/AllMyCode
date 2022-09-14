package Utils;

import java.time.LocalDate;

public class DateFactory {
    public static LocalDate getLocalDate() {
        int day = (int)(Math.random()*28)+1;
        int month = (int)(Math.random()*12)+1;
        int year = (int)(Math.random()*51)+1960;
        return LocalDate.of(year,month,day);
    }


}
