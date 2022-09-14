package bins;

import Utils.BirthdayStatistics;
import tasks.BirthdayTask;

import java.util.*;

public class BirthdaySystemReminder {
    private static BirthdaySystemReminder instance = null;
    private Set<Person> people;
    private BirthdayTask task;
    private static Scanner scanner;

    private BirthdaySystemReminder() {
        people = new HashSet<>();
        scanner = new Scanner(System.in);
        //task = new BirthdayTask(people);
        startSystem();

    }

    public static BirthdaySystemReminder getInstance() {
        if (instance == null) {
            instance = new BirthdaySystemReminder();
        }
        return instance;
    }



    public Set<Person> getPeople() {
        return people;
    }

    public BirthdayTask getTask() {
        return task;
    }

    public void showMenu() {
        System.out.println("1. Add Friend\n" +
                "2. Delete friend\n" +
                "3. Display all\n" +
                "4. Number of friends\n" +
                "5. Happiest month\n" +
                "6. Saddest month\n" +
                "7. Events per month\n" +
                "8. Exit\n" +
                "---------------------------------------------------------------\n");
    }

    public void startSystem() {
        boolean run = true;
        //Thread thread = new Thread(getTask());
        // thread.start();
        while (run) {

            showMenu();
            int menu;
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    addPerson(new Person());
                    System.out.println(people.size());
                    break;
                case 2:
                    System.out.println("which to remove?");
                    int remove = scanner.nextInt();

                    deletePerson(remove);
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    System.out.println(people.size());
                    break;
                case 5:
                    printHappyMonth();
                    break;
                case 6:
                    printSadlyMonth();
                    break;
                case 7:
                    printEvents();
                    break;
                case 8:
                    endSystem();
                    run = false;
                    break;
                default:
                    menu = 0;
                    break;
            }
        }
        // thread.stop();
    }

    public void endSystem() {
        System.out.println("thanksyou and byby");
        scanner.close();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addManyPeople(int many) {
        for (int i = 0; i < many; i++) {
            addPerson(new Person());
        }
    }

    public void deletePerson(int id) {
        Person toRemove = null;
        boolean remove = false;
        for (Person p: people) {
            if (p.getId() == id) {
                toRemove = p;
                remove = true;
                break;
            }
        }
        if (remove) people.remove(toRemove);
    }

    public void printAll() {
        System.out.println(getSorted(people));
    }

    private List<Person> getSorted(Set<Person> set) {
        List<Person> people = new ArrayList<>(set);
        Collections.sort(people);
        return people;
    }

    public void printStatistics() {
        printAll();
        printEvents();
        printHappyMonth();
        printSadlyMonth();
    }

    public void printEvents() {
        for (int i = 1; i < 13; i++) {
            printMonth(i);
        }
    }

    public void printHappyMonth() {
        printMonth(BirthdayStatistics.getHappyMonth());
    }

    public void printSadlyMonth() {
        printMonth(BirthdayStatistics.getSaddestMonth());
    }

    private void printMonth(int month) {
        System.out.println("month " + month + ": " + BirthdayStatistics.eventsInMonth(month) + " birthdays");
    }
}
