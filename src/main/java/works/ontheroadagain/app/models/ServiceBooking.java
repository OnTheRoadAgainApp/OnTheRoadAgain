package works.ontheroadagain.app.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="service_bookings")
public class ServiceBooking {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    //    what type of that time period? HN - not sure... can look at datetime or time for data type TJ
    @Column(nullable = false)
    private String service_time;

    @Column  //(nullable = false) removing nullability because at creation cost not available TJ
    private double cost;

//    @OneToOne
//    private User user;

    //    advisor_id??? we have one userid related to customer... HN
    @OneToOne
    private User advisor;

    @OneToOne
    private User technician;

    @OneToOne //vehicle not nullable because need vehicle entered to create booking
    private Vehicle vehicle;

    @OneToOne
    private ServiceType service_type;

    @OneToOne
    private Event status;


    public ServiceBooking() {
    }

    public ServiceBooking(Date date, String service_time, User advisor, Vehicle vehicle, ServiceType service_type) {
        this.date = date;
        this.service_time = service_time;
//        this.user = user;
        this.advisor = advisor;
        this.vehicle = vehicle;
        this.service_type = service_type;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }

    public Event getStatus() {
        return status;
    }

    public void setStatus(Event status) {
        this.status = status;
    }
}
