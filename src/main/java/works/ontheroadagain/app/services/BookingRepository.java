package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;

import java.util.List;

public interface BookingRepository extends CrudRepository<ServiceBooking, Long> {
    ServiceBooking findByVehicle(Vehicle vehicle);
    List<ServiceBooking> findAllByVehicle(Vehicle vehicle);
    List<ServiceBooking> findAllByTechnician(User user);
    ServiceBooking findById(Long id);
}
