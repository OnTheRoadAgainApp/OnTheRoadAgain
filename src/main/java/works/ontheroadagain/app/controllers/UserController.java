package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.VehicleRepository;

@Controller
public class UserController {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private VehicleRepository vehicleRepository;

    public UserController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, VehicleRepository vehicleRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.vehicleRepository = vehicleRepository;
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
        currentUser.setVehicles(vehicleRepository.findAllByUser(currentUser));
        model.addAttribute("user", currentUser);
        return "users/profile";

    }

}

