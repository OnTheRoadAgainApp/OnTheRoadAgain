package works.ontheroadagain.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.services.ServiceBookingRepository;
import works.ontheroadagain.app.services.ServiceBookingService;
import works.ontheroadagain.app.services.UserRepository;

@Controller
public class ServiceBookingController {

    @Autowired
    ServiceBookingRepository serviceBookingRepository;

    @Autowired
    UserRepository userRepository;

    private final ServiceBookingService serviceBookingService;


    public ServiceBookingController(ServiceBookingRepository serviceBookingRepository, ServiceBookingService serviceBookingService) {
        this.serviceBookingRepository = serviceBookingRepository;
        this.serviceBookingService = serviceBookingService;
    }


    @GetMapping("/advisor")
    public String vehicles(Model model) {
        model.addAttribute("serviceBookings", serviceBookingService.findAll());
        return "advisor";
    }
    
}