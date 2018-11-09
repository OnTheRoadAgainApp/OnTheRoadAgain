package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
