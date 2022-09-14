package bins;

import Utils.DateFactory;
import Utils.DateUtil;

import java.time.LocalDate;

public class Person implements Comparable<Person>{
    private static int idx;
    private int id;
    private String name;
    private LocalDate birthday;

    public Person() {
        this.id = idx;
        this.name = "Person " + idx++;
        this.birthday = DateFactory.getLocalDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person o) {
        return this.hashCode()-o.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return (compareTo((Person) obj) == 0);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.birthday.getDayOfYear();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + DateUtil.beautifyDate(birthday) +
                "}\n";
    }
}
