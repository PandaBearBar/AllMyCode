package mivhan3API.Beans;

import mivhan3API.Utils.FactoryUtils;

import java.util.Calendar;

public class Reminder implements Comparable<Reminder>{
    private static int id = 1;
    private static final boolean [] ranBol = {true,false};
    private Calendar expiration;
    private String text;
    private boolean important;
    private boolean popped;

    public Reminder(Calendar expiration) {
        this.expiration = expiration;
        text = "Task "+String.format("%03d", id);
        id++;
        important = ranBol[FactoryUtils.initInt(2, 0)];
        popped = ranBol[FactoryUtils.initInt(2, 0)];
    }

    public Calendar getExpiration() {
        return expiration;
    }

    public void setExpiration(Calendar expiration) {
        this.expiration = expiration;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    @Override
    public int compareTo(Reminder o) {
        return (int) (this.expiration.getTimeInMillis() - o.getExpiration().getTimeInMillis());

    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "expiration=" + expiration.getTime() +
                ", text='" + text + '\'' +
                ", important=" + important +
                ", popped=" + popped +
                '}';
    }
}
