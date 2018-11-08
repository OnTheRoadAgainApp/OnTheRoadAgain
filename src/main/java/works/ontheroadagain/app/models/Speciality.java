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

    public Speciality(long id, String name) {
        this.id = id;
        this.name = name;
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
}
