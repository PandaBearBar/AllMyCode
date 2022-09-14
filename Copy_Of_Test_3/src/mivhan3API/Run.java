package mivhan3API;

import java.util.Calendar;

public class Run {
    public static void main(String[] args) {
//        ReminderSystem reminderSystem = new ReminderSystem();
//        reminderSystem.startSystem();
        System.out.println(Calendar.getInstance().getTimeInMillis());
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2022, Calendar.MARCH, 24, 13, 5);
        System.out.println(cal.getTimeInMillis());
    }
}
