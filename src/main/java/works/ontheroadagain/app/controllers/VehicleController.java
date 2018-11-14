package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.UserRepository;
import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

import java.sql.SQLOutput;

@Controller
public class VehicleController {
//    private final VehicleService vehicleSvc;
    private final VehicleRepository vehicleRepo;
    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;

    public VehicleController(VehicleRepository vehicleRepo, BookingRepository bookingRepo, UserRepository userRepo) {
        this.vehicleRepo = vehicleRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/vehicles")
    public String vehicles(Model m) {
        m.addAttribute("vehicles", vehicleRepo.findAll());
        return "vehicles";
    }

    @GetMapping("/vehicles/add")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/addVehicle";
    }

    @PostMapping("/vehicles/add")
    public String create(Model m, @ModelAttribute Vehicle vehicle) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vehicle.setUser(currentUser);
        vehicleRepo.save(vehicle);

        return "redirect:/profile";
    }

}
