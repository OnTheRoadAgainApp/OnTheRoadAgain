package works.ontheroadagain.app.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="service_events")
public class ServiceEvent {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Date date;

    @OneToOne
    private ServiceBooking service_booking;

    @OneToOne
    private Event event;

    @OneToOne
    private User technician;

    public ServiceEvent() {
    }

    public ServiceEvent(Date date, ServiceBooking service_booking, Event event, User technician) {
        this.date = date;
        this.service_booking = service_booking;
        this.event = event;
        this.technician = technician;
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

    public ServiceBooking getService_booking() {
        return service_booking;
    }

    public void setService_booking(ServiceBooking service_booking) {
        this.service_booking = service_booking;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }
}