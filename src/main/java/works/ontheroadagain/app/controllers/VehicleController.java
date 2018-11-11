package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class VehicleController {
//    private final VehicleService vehicleSvc;
    private final VehicleRepository vehicleRepo;
    private final BookingRepository bookingRepo;

    public VehicleController(VehicleRepository vehicleRepo, BookingRepository bookingRepo) {
        this.vehicleRepo = vehicleRepo;
        this.bookingRepo = bookingRepo;
    }

    @GetMapping("/vehicles")
    public String vehicles(Model m) {
        m.addAttribute("vehicles", vehicleRepo.findAll());
        return "/vehicles";
    }

    @GetMapping("/vehicles/add")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "/addVehicle";
    }

    @PostMapping("/vehicles/add")
    public String create(Model m, @ModelAttribute Vehicle vehicle) {
        vehicleRepo.save(vehicle);
        m.addAttribute("vehicles", vehicleRepo.findAll());
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/book")
    public String showBookingForm(Model model) {
        model.addAttribute("serviceBooking", new ServiceBooking());
        return "vehicles/createBooking";
    }

    @PostMapping("/vehicles/book")
    public String book(@ModelAttribute ServiceBooking booking, @RequestParam("advise") String advise) {
        User thisUser = booking.getAdvisor();
        booking.setAdvisor(new User(advise));
        bookingRepo.save(booking);
        return "users/profile";
    }
}
