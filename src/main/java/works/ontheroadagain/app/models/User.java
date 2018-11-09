package works.ontheroadagain.app.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String first_name;

    @Column(nullable = false, length = 100)
    private String last_name;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String  email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private long phone_number;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false)
    private long zipcode;

    //    aused by: org.hibernate.AnnotationException: mappedBy reference an unknown target entity property:
// works.ontheroadagain.app.models.Vehicle.vehicle in works.ontheroadagain.app.models.User.vehicles
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vehicle> vehicles;

    @OneToOne
    private UserRole user_role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_specialities",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="speciality_id")}
    )
    private List<Speciality> specialities;



    public User() {
    }

    public User(String first_name, String last_name, String username, String email, String password, long phone_number,
                String address, String city, String state, long zipcode, UserRole user_role ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.user_role = user_role;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public UserRole getUser_role() {
        return user_role;
    }

    public void setUser_role(UserRole user_role) {
        this.user_role = user_role;
    }
}
