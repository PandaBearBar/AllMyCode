import Utils.BirthdayStatistics;
import bins.BirthdaySystemReminder;

public class Run {
    public static void main(String[] args) {
        BirthdaySystemReminder system = BirthdaySystemReminder.getInstance();
        System.out.println(new BirthdayStatistics());
    }

}
