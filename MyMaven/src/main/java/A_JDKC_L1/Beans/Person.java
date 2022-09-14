package A_JDKC_L1.Beans;

public class Person {
    private int id;
    private String fName;
    private String lName;
    private String PhoneNumber;
    private String city;

    public Person() {
    }

    public Person(String fName, String lName, String phoneNumber, String city) {
        this.fName = fName;
        this.lName = lName;
        PhoneNumber = phoneNumber;
        this.city = city;
    }

    public Person(int id, String fName, String lName, String phoneNumber, String city) {
        this(fName, lName, phoneNumber, city);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
