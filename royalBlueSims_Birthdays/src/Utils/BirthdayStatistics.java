package Utils;

import bins.BirthdaySystemReminder;
import bins.Person;

import java.util.*;

public class BirthdayStatistics {
    private static Set<Person> list = new TreeSet<>(BirthdaySystemReminder.getInstance().getPeople());

    public BirthdayStatistics() {
    }

    public static int getHappyMonth() {
        return Collections.max(getEvents().entrySet(),Map.Entry.comparingByValue()).getKey();
    }

    public static int getSaddestMonth() {
        return Collections.min(getEvents().entrySet(),Map.Entry.comparingByValue()).getKey();
    }

    public static int eventsInMonth(int month) {
        return getEvents().get(month);
    }

    private static Map<Integer,Integer> getEvents() {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < 13; i++) {
            map.put(i, countMonth(i));
        }
        return map;
    }

    private static Integer countMonth(int i) {
        int idx =0;
        System.out.println(BirthdaySystemReminder.getInstance().getPeople());
        for (Person p : BirthdaySystemReminder.getInstance().getPeople()) {
            if (i == p.getBirthday().getMonthValue())idx++;
        }
        return idx;
    }

    @Override
    public String toString() {
        return "BirthdayStatistics{" +
                "list=" + BirthdaySystemReminder.getInstance().getPeople() +
                '}';
    }

}
