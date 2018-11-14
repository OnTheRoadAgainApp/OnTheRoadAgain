package works.ontheroadagain.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.ServiceBookingRepository;
import works.ontheroadagain.app.services.ServiceBookingService;
import works.ontheroadagain.app.services.UserRepository;

@Controller
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;



    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @GetMapping("/advisor")
    public String vehicles(Model model) {
        model.addAttribute("serviceBookings", bookingRepository.findAll());
        return "users/advisor";
    }


    
}