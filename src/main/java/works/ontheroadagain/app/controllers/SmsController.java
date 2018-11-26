package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.EventRepository;
import works.ontheroadagain.app.services.SmsSender;

@Controller
public class SmsController {
    BookingRepository bookingRepo;
    EventRepository eventRepo;

    SmsController(BookingRepository bookingRepo, EventRepository eventRepo) {
        this.bookingRepo = bookingRepo;
        this.eventRepo = eventRepo;
    }

    @GetMapping("/send")
    public String vehicleAppointmentPage(){
        SmsSender smsSender = new SmsSender();
        smsSender.sendText();

        return "redirect:/advisor";
    }

    @PostMapping("/send")
    public String sendSMS(@RequestParam("bookingId") Long bookingId){
        SmsSender smsSender = new SmsSender();
        smsSender.sendText();
        ServiceBooking currentBooking = bookingRepo.findById(bookingId);
        currentBooking.setStatus(eventRepo.findById(10L));
        bookingRepo.save(currentBooking);
        return "redirect:/book/" + bookingId;
    }
}
