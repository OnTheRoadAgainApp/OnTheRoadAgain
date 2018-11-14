package works.ontheroadagain.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @GetMapping(path = "/book/{id}")
    public String bookingsId(@PathVariable long id, Model vModel) {

        vModel.addAttribute("bookings", bookingRepository.findOne(id));
        return "users/showBooking";
    }
    
}