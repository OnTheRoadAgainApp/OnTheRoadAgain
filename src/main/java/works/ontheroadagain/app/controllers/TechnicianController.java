package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.Event;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.BookingRepository;

import works.ontheroadagain.app.services.EventRepository;

import works.ontheroadagain.app.services.SmsSender;

import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TechnicianController {
        private SmsSender smsSender;
        private final VehicleRepository vehicleRepository;
        private final BookingRepository bookingRepo;
        private final EventRepository eventRepository;





    public TechnicianController(VehicleRepository vehicleRepository, BookingRepository bookingRepo, SmsSender smsSender,EventRepository eventRepository) {
        this.smsSender = smsSender;

        this.vehicleRepository = vehicleRepository;
        this.bookingRepo = bookingRepo;
        this.eventRepository = eventRepository;
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



    @GetMapping("/booking/service/{bookingId}")
    public String vehicleAppointmentPage(Model model, @PathVariable Long bookingId){
        model.addAttribute("booking", bookingRepo.findById(bookingId));

        int statusId = (int) bookingRepo.findOne(bookingId).getStatus().getId();
        int pWidth = 0;
        String pColor = "";
        switch (statusId) {
            case 1: pWidth = 5;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 2: pWidth = 15;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 3: pWidth =  30;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 4: pWidth =  30;
                pColor = "bg-danger progress-bar-striped progress-bar-animated";
                break;
            case 5: pWidth = 50;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 6: pWidth = 50;
                pColor = "bg-danger progress-bar-striped progress-bar-animated";
                break;
            case 7: pWidth = 75;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 8: pWidth = 75;
                pColor = "bg-danger progress-bar-striped progress-bar-animated";
                break;
            case 9: pWidth = 90;
                pColor = "bg-warning progress-bar-striped progress-bar-animated";
                break;
            case 10: pWidth = 100;
                pColor = "bg-success ";
                break;
        }

        model.addAttribute("width", pWidth);
        model.addAttribute("color", pColor);

        return "vehicleAppointment";

    }

//    This is where it theoretically should update status
    @PostMapping("booking/{bookingId}/update")
    public String vehicleAppointmentStatus(@ModelAttribute Event status, @RequestParam("status") String[] statusId,
                                           @PathVariable Long bookingId){

//        //to ensure highest number
//        Long highestStatus = 0L;
//        for(String id : statusId) {
//            System.out.println(id);
//            if (Long.valueOf(id) > highestStatus)
//                highestStatus = Long.valueOf(id);
//        }

        System.out.println();

        Event updateStatus = eventRepository.findById(Long.valueOf(statusId[statusId.length-1]));

        ServiceBooking updatedBooking = bookingRepo.findById(bookingId);

        updatedBooking.setStatus(updateStatus);

        bookingRepo.save(updatedBooking);

        return "redirect:/booking/service/" + bookingId;
    }

}
