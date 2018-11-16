package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TechnicianController {
        private final VehicleRepository vehicleRepository;
        private final BookingRepository bookingRepo;



    public TechnicianController(VehicleRepository vehicleRepository, BookingRepository bookingRepo) {
        this.vehicleRepository = vehicleRepository;
        this.bookingRepo = bookingRepo;
    }



    @GetMapping("/technicians")
    public String technicianHomePage(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ServiceBooking> bookings = bookingRepo.findAllByTechnician(currentUser);
        model.addAttribute("serviceBookings", bookings);

        List<Vehicle> vehicles = new ArrayList<>();
        for(ServiceBooking booking : bookings) {
            vehicles.add(booking.getVehicle()) ;
        }
        model.addAttribute("vehicles",vehicles);
        return "technicians";
    }


    @GetMapping("/booking/{bookingId}")
    public String vehicleAppointmentPage(Model model, @PathVariable Long bookingId){
        model.addAttribute("booking", bookingRepo.findById(bookingId));
        return "vehicleAppointment";

    }
}
