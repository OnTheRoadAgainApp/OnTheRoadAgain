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

    @GetMapping("/vehicles/book")
    public String showBookingForm(Model model) {
        //adding empty service booking to be filled by form
        model.addAttribute("serviceBooking", new ServiceBooking());

        //finding current user and their vehicles
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("vehicles", vehicleRepo.findAllByUser(currentUser));

        //find all service types to populate form


        //find advisors to populate form


        return "vehicles/createBooking";
    }

    @PostMapping("/vehicles/book")
    public String book(@ModelAttribute ServiceBooking booking, @RequestParam("advise") String advise,
                       @RequestParam("license") String license) {

        booking.setAdvisor(userRepo.findByFirst(advise));
        booking.setVehicle(vehicleRepo.findByLicense(license));
        bookingRepo.save(booking);
        return "users/profile";
    }
}
