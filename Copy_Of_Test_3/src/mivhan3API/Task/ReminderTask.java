package mivhan3API.Task;

import mivhan3API.Beans.Reminder;
import mivhan3API.System.ReminderSystem;

import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

public class ReminderTask implements Runnable {
    private Set<Reminder> reminders = new TreeSet<>();

    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    private synchronized void updateReminders(Reminder reminder){
        if (reminder.getExpiration().getTimeInMillis() <= Calendar.getInstance().getTimeInMillis())reminders.remove(reminder);
    }

    @Override
    public void run() {
        System.out.println("Reminder task's start");
        while (ReminderSystem.isIsWorking()) {
            try {
                for (Reminder r: reminders) {
                    if (r.getExpiration().getTimeInMillis() >= Calendar.getInstance().getTimeInMillis()) {
                        if (r.getExpiration().getTimeInMillis()==Calendar.getInstance().getTimeInMillis()){
                            System.out.println("The Task start now :\n" + r);
                        }
                        else if (r.isImportant()) {
                            Thread thread = new Thread(new ImportantReminderTask(r));
                            System.out.println("Important Task ahead");
                            thread.start();
                            thread.join();
                        }else if (r.isPopped()) System.out.println("Poped Task :" + r);
                        else if (r.getExpiration().getTimeInMillis() -60_000 == Calendar.getInstance().getTimeInMillis())
                            System.out.println("The Task start in a min :\n" + r);
                    }
                    updateReminders(r);
                }
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reminder task's end");
    }
}
