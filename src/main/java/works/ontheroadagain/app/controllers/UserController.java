package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private VehicleRepository vehicleRepository;
    private BookingRepository bookingRepo;

    public UserController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, VehicleRepository vehicleRepository, BookingRepository bookingRepo) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.vehicleRepository = vehicleRepository;
        this.bookingRepo = bookingRepo;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";

    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Vehicle> currentVehicles = vehicleRepository.findAllByUser(currentUser);
        currentUser.setVehicles(vehicleRepository.findAllByUser(currentUser));
        model.addAttribute("user", currentUser);

        List<ServiceBooking> bookings = new ArrayList<>();
        for(Vehicle vehicle : currentVehicles) {
            bookings.addAll(bookingRepo.findAllByVehicle(vehicle));
        }
        System.out.println(bookings);
        model.addAttribute("bookings", bookings);
        return "users/profile";

    }

    @GetMapping("/Meet")
    public String aboutUsPage() {
        return "users/aboutUs";

    }

    @GetMapping("/Privacy")
    public String privacyStatementPage() {
        return "users/privacy";

    }

//    @GetMapping("/advisor")
//    public String showAdvisorPage(Model model) {
//        model.addAttribute("user", new User());
//        return "users/advisor";
//
//    }

}


