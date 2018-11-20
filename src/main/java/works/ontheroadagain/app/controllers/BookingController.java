package works.ontheroadagain.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import works.ontheroadagain.app.models.Event;
import works.ontheroadagain.app.models.ServiceBooking;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.services.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import works.ontheroadagain.app.services.BookingRepository;
import works.ontheroadagain.app.services.ServiceBookingRepository;
import works.ontheroadagain.app.services.ServiceBookingService;
import works.ontheroadagain.app.services.UserRepository;

@Controller
public class BookingController {

    private final VehicleRepository vehicleRepo;
    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ServiceTypeRepository serviceTypeRepo;
    private final RolesRepository rolesRepo;
    private final EventRepository eventRepo;

    public BookingController(VehicleRepository vehicleRepo, BookingRepository bookingRepo, UserRepository userRepo,
                             ServiceTypeRepository serviceTypeRepo, RolesRepository rolesRepo, EventRepository eventRepo) {
        this.vehicleRepo = vehicleRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.serviceTypeRepo = serviceTypeRepo;
        this.rolesRepo = rolesRepo;
        this.eventRepo = eventRepo;
    }

    @GetMapping("/booking/create")
    public String showBookingForm(Model model) {
        //adding empty service booking to be filled by form
        model.addAttribute("serviceBooking", new ServiceBooking());

        //finding current user and their vehicles
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("vehicles", vehicleRepo.findAllByUser(currentUser));

        //find all service types to populate form
        model.addAttribute("serviceTypes", serviceTypeRepo.findAll());

        //find advisors to populate form
        model.addAttribute("advisors", userRepo.findAllByRole(rolesRepo.findById(2L)));

        return "vehicles/createBooking";
    }

    @PostMapping("/booking/create")
    public String book(@ModelAttribute ServiceBooking booking, @RequestParam("advise") Long advisorId,
                       @RequestParam("license") String license, @RequestParam("service-type") Long serviceId) {
        booking.setAdvisor(userRepo.findById(advisorId));
        booking.setVehicle(vehicleRepo.findByLicense(license));
        booking.setService_type(serviceTypeRepo.findById(serviceId));
        String selectedTime = booking.getService_time();
        System.out.println(selectedTime);
        booking.getDate().setHours(Integer.valueOf(selectedTime.substring(0, 2)));
        booking.getDate().setMinutes(Integer.valueOf(selectedTime.substring(3)));
        booking.setStatus(eventRepo.findOne(1L));
        bookingRepo.save(booking);
        return "redirect:/profile";
    }

    @PostMapping("book/cancel/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingRepo.delete(id);
        return "redirect:/profile";
    }

    @GetMapping("/advisor")
    public String vehicles(Model model) {
        model.addAttribute("serviceBookings", bookingRepo.findAll());
        model.addAttribute("technicians", userRepo.findAllByRole(rolesRepo.findById(3L)));
        return "users/advisor";
    }

    //assign a technician to booking
    @PostMapping("/advisor")
    public String technician(@ModelAttribute ServiceBooking serviceBooking, @RequestParam("tech") Long technicianId,
                             @RequestParam("booking-id") Long bookingId){
        ServiceBooking booking = bookingRepo.findOne(bookingId);
        booking.setTechnician(userRepo.findById(technicianId));
        bookingRepo.save(booking);
        return "redirect:/advisor";
    }



    @GetMapping(path = "/book/{id}")
    public String bookingsId(@PathVariable long id, Model vModel) {
        ServiceBooking booking = bookingRepo.findOne(id);
        vModel.addAttribute("booking", booking);
        vModel.addAttribute("status", booking.getStatus().getDescription());
        int statusId = (int) bookingRepo.findOne(id).getStatus().getId();
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
        vModel.addAttribute("width", pWidth);
        vModel.addAttribute("color", pColor);
        return "users/showBooking";
    }



}