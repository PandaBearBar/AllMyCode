package A_JDKC_L1.Beans;

public class Cat {
    private String name;
    private float weight;
    private String city;
    private int Id;

    public Cat() {
    }

    public Cat(String name, float age, String city) {
        this.name = name;
        this.weight = age;
        this.city = city;
    }

    public Cat(String name, float age, String city, int id) {
        this(name, age, city);
        Id = id;
    }
    public Cat(Cat cat) {
        this.Id = cat.Id;
        this.name = cat.name;
        this.weight = cat.weight;
        this.city = cat.city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return weight;
    }

    public void setAge(float age) {
        this.weight = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "\nCat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", city='" + city + '\'' +
                ", Id=" + Id +
                '}';
    }
}
