package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.ServiceBooking;

public interface ServiceBookingRepository extends CrudRepository<ServiceBooking, Long> {

}
