package tasks;

import Utils.DateUtil;
import bins.Person;

import java.time.LocalDate;
import java.util.Set;

public class BirthdayTask implements Runnable{

    private Set<Person> people;

    public BirthdayTask(Set<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (people) {
                for (Person p : people) {
                    if (p.hashCode() == LocalDate.now().getDayOfYear()) printBirthday(p);
                }
                System.out.println("ran");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printBirthday(Person friend) {
        System.out.println(friend.getName() + " has a birthday today! the " + DateUtil.beautifyDate(LocalDate.now()) + ", be sure to congratulate them");
    }
}
