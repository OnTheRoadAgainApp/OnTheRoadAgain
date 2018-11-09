package works.ontheroadagain.app.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="service_bookings")
public class ServiceBooking {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Date service_date;

    //    what type of that time period?
    @Column(nullable = false)
    private String service_time;

    @Column(nullable = false)
    private double cost;

    @OneToOne
    private User user_id;

    //    advisor_id??? we have one userid releted to customer...
    @OneToOne
    private User advisor_id;

    @OneToOne
    private Vehicle vehicle_id;

    @OneToOne
    private ServiceType service_type_id;






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Vehicle getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Vehicle vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public ServiceType getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(ServiceType service_type_id) {
        this.service_type_id = service_type_id;
    }
}
