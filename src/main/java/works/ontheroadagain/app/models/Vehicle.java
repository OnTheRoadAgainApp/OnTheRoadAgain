package works.ontheroadagain.app.models;


import javax.persistence.*;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, length = 20, unique = true)
    private String  license;

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false)
    private long mileage;

    @Column(nullable = true)
    private long engine_size;

    @Column(nullable = false, length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Vehicle() {
    }

    public Vehicle(Integer year, String license, String make, String model, long mileage, long engine_size, String color, User user) {
        this.year = year;
        this.license = license;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.engine_size = engine_size;
        this.color = color;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public long getEngine_size() {
        return engine_size;
    }

    public void setEngine_size(long engine_size) {
        this.engine_size = engine_size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
