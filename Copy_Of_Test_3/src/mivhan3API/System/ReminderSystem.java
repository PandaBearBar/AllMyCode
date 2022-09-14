package mivhan3API.System;

import mivhan3API.Beans.Reminder;
import mivhan3API.Task.ReminderTask;
import mivhan3API.Utils.FactoryUtils;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ReminderSystem {
    private Set<Reminder> reminders = new TreeSet<>(new Comparator<Reminder>() {
        @Override
        public int compare(Reminder o1, Reminder o2) {
            return (int) (o1.getExpiration().getTimeInMillis() - o2.getExpiration().getTimeInMillis());
        }
    });
    private ReminderTask task = new ReminderTask(reminders);
    private static boolean isWorking = true;
    private static Scanner scanner = new Scanner(System.in);

    public ReminderSystem() {
        Thread thread = new Thread(task);
        thread.start();
    }

    public static boolean isIsWorking() {
        return isWorking;
    }

    public static void setIsWorking(boolean isWorking) {
        ReminderSystem.isWorking = isWorking;
    }

    public Set<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    public ReminderTask getTask() {
        return task;
    }

    public void setTask(ReminderTask task) {
        this.task = task;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private void showMenu() {
        System.out.println("" +
                "Hello User / Kobi\n" +
                "1. Add Reminder\n" +
                "2.Print All Log Reminders\n" +
                "3.Exit program\n" +
                "Write your choice pls : ");
    }

    private void lastMessage() {
        System.out.println("Done");
    }

    private void invalidMes() {
        System.out.println("Invalid Input...");
    }

    public void startSystem() {
        while (isWorking) {
            showMenu();
            switch (initNum(scanner.next())) {
                case 1:
                    ReminderTree();
                    break;
                case 2:
                    printAll();
                    break;
                case 3:
                    endSystem();
                    break;
                default:

                    break;
            }
        }
    }

    private void ReminderTree() {
        System.out.println("" +
                "Esay way :\n" +
                "1.Random Detail only with free hand about the time of the task ;)\n" +
                "Hard way :\n" +
                "2.I Want To Choose every single thing !");
        switch (initNum(scanner.next())) {
            case 1:
                addReminder();
                break;
            case 2:
                spesificReminder();
                break;
            default:
                invalidMes();
                break;
        }
    }

    private void spesificReminder() {
        System.out.println("Lets start by set The date :");
        Reminder r = new Reminder(FactoryUtils.setCalFrom0());
        System.out.println("is the task need to be poped ?");
        r.setPopped(scanner.nextBoolean());
        System.out.println("is the task need to be important ?");
        r.setImportant(scanner.nextBoolean());
        System.out.println("how would u want to call the task ?");
        r.setText(scanner.next());
        reminders.add(r);
    }

    private void addReminder() {
        reminderMenu();
        switch (initNum(scanner.next())) {
            case 1:
                reminders.add(new Reminder(FactoryUtils.initCal(1)));
                break;
            case 2:
                reminders.add(new Reminder(FactoryUtils.initCal(5)));
                break;
            case 3:
                reminders.add(new Reminder(FactoryUtils.initCal(10)));
                break;
            case 4:
                reminders.add(new Reminder(FactoryUtils.initCal(15)));
                break;
            case 5:
                reminders.add(new Reminder(FactoryUtils.initCal(30)));
                break;
            case 6:
                reminders.add(new Reminder(FactoryUtils.initCal(60)));
                break;
            case 7:
                reminders.add(new Reminder(FactoryUtils.initCal(90)));
                break;
            case 8:
                try {
                    reminders.add(new Reminder(FactoryUtils.setCalFrom0()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("NVM have been chosen so bye");
                break;
        }
        lastMessage();
    }

    private void reminderMenu() {
        System.out.println("" +
                "1 -> 1 min from now\n" +
                "2 -> 5 min from now\n" +
                "3 -> 10 min from now\n" +
                "4 -> 15 min from now\n" +
                "5 -> 30 min from now\n" +
                "6 -> 1 hour from now \n" +
                "7 -> 1 hour & 30 min from now \n" +
                "8 -> Set urself the task time **Remember not ot put a past time cuz u won't see it\n" +
                "9 -> NVM...");
    }

    private void printAll() {
        for (Reminder r: reminders) {
            System.out.println(r);
        }
        lastMessage();
    }

    private void endSystem() {
        scanner.close();
        System.out.println("Bye Bye");
        isWorking = false;
    }

    private int initNum(String In) {
        boolean isNum = true;
        for (int i = 0; i < In.length(); i++) {
            if (!In.matches("[0-9]+")) isNum = false;
        }
        return (isNum) ? Integer.parseInt(In) : 0;
    }

    @Override
    public String toString() {
        return "ReminderSystem{" +
                "reminders=" + reminders +
                '}';
    }
}
