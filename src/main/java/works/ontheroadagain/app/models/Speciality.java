package works.ontheroadagain.app.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="specialities")
public class Speciality {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @ManyToMany(mappedBy = "specialities")
    private List<User> users;


    public Speciality() {
    }


    public Speciality(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
