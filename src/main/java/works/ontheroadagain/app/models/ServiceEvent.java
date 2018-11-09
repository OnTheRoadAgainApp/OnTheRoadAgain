package works.ontheroadagain.app.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vehicles")
public class ServiceEvent {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Date date;

    @OneToOne
    private ServiceBooking service_booking_id;

    @OneToOne
    private Event event_id;
    
    @OneToOne
    private User technician_id;

    public ServiceEvent() {
    }

    public ServiceEvent(Date date, ServiceBooking service_booking_id, Event event_id, User technician_id) {
        this.date = date;
        this.service_booking_id = service_booking_id;
        this.event_id = event_id;
        this.technician_id = technician_id;
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

    public ServiceBooking getService_booking_id() {
        return service_booking_id;
    }

    public void setService_booking_id(ServiceBooking service_booking_id) {
        this.service_booking_id = service_booking_id;
    }

    public Event getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Event event_id) {
        this.event_id = event_id;
    }

    public User getTechnician_id() {
        return technician_id;
    }

    public void setTechnician_id(User technician_id) {
        this.technician_id = technician_id;
    }
}