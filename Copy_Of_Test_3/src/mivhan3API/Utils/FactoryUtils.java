package mivhan3API.Utils;

import mivhan3API.System.ReminderSystem;

import java.time.LocalDateTime;
import java.util.Calendar;

public class FactoryUtils {
    public static int initInt(int max, int min){
        return (int)(Math.random()*(max-min)+min);
    }
    public static Calendar initCal (int minutes ){
        int hours = 0;
        if (minutes >= 60) {
            hours = minutes/60;
            minutes = minutes%60;
        }
        Calendar cal = Calendar.getInstance();
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        int hour = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();
        int second = LocalDateTime.now().getSecond();
        cal.set(year, month ,day,hour + hours,min + minutes,second);
        return cal;
    }
    public static Calendar setCalFrom0(){
        Calendar cal = Calendar.getInstance();
        cal.clear();
        System.out.println("Year of the Task ?");
        cal.add(Calendar.YEAR, ReminderSystem.getScanner().nextInt()-1970); // in my pc its gave me 2022 when i put 2022 and not 3991;
        System.out.println("Month of the Task ?");
        cal.add(Calendar.MONTH, ReminderSystem.getScanner().nextInt() -1 );
        System.out.println("Day of the Task ?");
        cal.add(Calendar.DATE, ReminderSystem.getScanner().nextInt());
        System.out.println("Hour of the Task ?");
        cal.add(Calendar.HOUR,ReminderSystem.getScanner().nextInt());
        System.out.println("Min of the Task ?");
        cal.add(Calendar.MINUTE,ReminderSystem.getScanner().nextInt());
        System.out.println("Sec of the Task ?");
        cal.add(Calendar.SECOND,ReminderSystem.getScanner().nextInt());
        return cal;
    }
}
