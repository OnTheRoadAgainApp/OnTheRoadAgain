package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class TechnicianController {

    @GetMapping("/technicians")
    public String technicianHomePage() {
        return "/technicians";
    }

//    @GetMapping("/vehicleAppointment/{id}")
//    public String showVehicleAppointment(@PathVariable long id, Model vModel){
//        vModel.addAttribute("vehicle", VehicleService.findOne(id));
//        return "/vehicleAppointment/{id}";
//    }
//
//    @PostMapping("/vehicleAppointment/{id}")
//    public String showVehicleAppointment(@ModelAttribute Vehicle vehicle) {
//        Vehicle vehicleAppt = VehicleService.save(vehicle);
//        return "redirect:/vehicleAppointment/{id}" + vehicleAppt.getId();
//    }
}
