package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends CrudRepository<ServiceBooking, Long> {

      List<ServiceBooking> findAllByVehicle (Vehicle vehicle);
      List<ServiceBooking> findAllByDateBefore(Date today);
      List<ServiceBooking> findAllByDateAfter(Date today);
      List<ServiceBooking> findAllByVehicleAndDateBefore(Vehicle vehicle, Date today);
      List<ServiceBooking> findAllByVehicleAndDateAfter(Vehicle vehicle, Date today);
      List<ServiceBooking> findAllByTechnician (User user);
      ServiceBooking findById (Long id);
}
