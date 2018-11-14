package works.ontheroadagain.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    public BookingController(VehicleRepository vehicleRepo, BookingRepository bookingRepo, UserRepository userRepo,
                             ServiceTypeRepository serviceTypeRepo, RolesRepository rolesRepo) {
        this.vehicleRepo = vehicleRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.serviceTypeRepo = serviceTypeRepo;
        this.rolesRepo = rolesRepo;
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
        bookingRepo.save(booking);
        return "redirect:/profile";
    }

    @GetMapping("/advisor")
    public String vehicles(Model model) {
        model.addAttribute("serviceBookings", bookingRepo.findAll());
        return "users/advisor";
    }


    @GetMapping(path = "/book/{id}")
    public String bookingsId(@PathVariable long id, Model vModel) {

        vModel.addAttribute("bookings", bookingRepo.findOne(id));
        return "users/showBooking";
    }

}