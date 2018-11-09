package works.ontheroadagain.app.models;

import javax.persistence.*;

@Entity
@Table(name="Service_types")
public class ServiceType {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String description;

    public ServiceType() {
    }

    public ServiceType(String description) {
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
