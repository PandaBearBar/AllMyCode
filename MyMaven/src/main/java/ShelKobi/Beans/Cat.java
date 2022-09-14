package ShelKobi.Beans;

/**
 * Created by kobis on 22 Mar, 2022
 */
public class Cat {

    private int id;
    private String name;
    private float weight;
    private String city;

    public Cat() {
    }
    
    public Cat(Cat cat) {
        this.id = cat.id;
        this.name = cat.name;
        this.weight = cat.weight;
        this.city = cat.city;
    }


    public Cat(String name, float weight, String city) {
        this.name = name;
        this.weight = weight;
        this.city = city;
    }

    public Cat(int id, String name, float weight, String city) {
       this(name, weight, city);
        this.id = id;

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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", city='" + city + '\'' +
                '}';
    }
}
