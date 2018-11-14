package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.repositories.UsersRepository;
import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class TechnicianController {
    //    private VehicleRepository vehicleRepository;
//
//    public TechnicianController(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }



    @GetMapping("/technicians")
    public String technicianHomePage() {
        return "technicians";
    }


    @GetMapping("/vehicleAppointment")
    public String vehicleAppointmentPage(){
        return "vehicleAppointment";

    }
}
