package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import works.ontheroadagain.app.services.SmsSender;

@Controller
public class SmsController {
    @GetMapping("/send")
    public String vehicleAppointmentPage(){
//        model.addAttribute("booking", bookingRepo.findById(bookingId));
        SmsSender smsSender = new SmsSender();
        smsSender.sendText();
        return "users/advisor";

    }
}
