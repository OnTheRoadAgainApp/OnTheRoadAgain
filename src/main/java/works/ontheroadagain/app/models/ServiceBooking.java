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

//    @OneToOne
//    private User user;

    //    advisor_id??? we have one userid releted to customer...
    @OneToOne
    private User advisor;

    @OneToOne
    private Vehicle vehicle;

    @OneToOne
    private ServiceType service_type;


    public ServiceBooking() {
    }

    public ServiceBooking(Date service_date, String service_time, double cost, User advisor, Vehicle vehicle, ServiceType service_type) {
        this.service_date = service_date;
        this.service_time = service_time;
        this.cost = cost;
//        this.user = user;
        this.advisor = advisor;
        this.vehicle = vehicle;
        this.service_type = service_type;
    }

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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public User getAdvisor() {
        return advisor;
    }

    public void setAdvisor(User advisor) {
        this.advisor = advisor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ServiceType getService_type() {
        return service_type;
    }

    public void setService_type(ServiceType service_type) {
        this.service_type = service_type;
    }
}
