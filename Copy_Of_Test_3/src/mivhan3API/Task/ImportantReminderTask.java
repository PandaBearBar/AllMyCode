package mivhan3API.Task;

import mivhan3API.Beans.Reminder;

import java.util.Calendar;

public class ImportantReminderTask implements Runnable {
    private Reminder reminder;

    public ImportantReminderTask(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                if (reminder.getExpiration().getTimeInMillis() >= Calendar.getInstance().getTimeInMillis()) {
                    System.out.println("Important TASK Reminder num : " + (i+1));
                    System.out.println(reminder);
                    Thread.sleep(1000 * 60);
                }else System.out.println("The important task have done or started already so GG WP");
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
        }

    }
}
