package works.ontheroadagain.app.services;

import org.springframework.stereotype.Service;
import works.ontheroadagain.app.models.ServiceBooking;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBookingService {
    private List<ServiceBooking> serviceBookings;

    public ServiceBookingService() {
        serviceBookings = new ArrayList<>();
        findAll();
    }

    public List<ServiceBooking> findAll() {
        return serviceBookings;
    }


    public ServiceBooking findOne(long id) {
        return serviceBookings.get((int) id - 1);
    }
    
}
