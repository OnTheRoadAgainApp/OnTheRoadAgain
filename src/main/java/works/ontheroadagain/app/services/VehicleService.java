package works.ontheroadagain.app.services;

import org.springframework.stereotype.Service;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private List<Vehicle> vehicles;

    public VehicleService() {
        vehicles = new ArrayList<>();
        createVehicles();
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(vehicles.size() + 1);
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle findOne(long id) {
        return vehicles.get((int) id - 1);
    }

    private void createVehicles() {
        save(new Vehicle(2012, "DV20109", "Mazda", "3", 40000, 1000, "dark gray", new User()));
        save(new Vehicle(2010, "bh7w357", "honda", "civic", 157000, 6, "silver", new User()));
    }
}

