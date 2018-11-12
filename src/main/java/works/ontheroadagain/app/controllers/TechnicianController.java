package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class TechnicianController {

    @GetMapping("/technicians")
    public String technicianHomePage() {
        return "/technicians";
    }

    @GetMapping("/vehicleAppt")
    public String showVehicleAppointment(){
//        @PathVariable long id, Model vModel
//        vModel.addAttribute("vehicle", VehicleService.findOne(id));
        return "/vehicleAppt";
    }
}
