package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class VehicleController {
    private final VehicleService vehicleSvc;

    public VehicleController(VehicleService vehicleSvc) {
        this.vehicleSvc = vehicleSvc;
    }

    @GetMapping("/vehicles")
    public String vehicles(Model m) {
        m.addAttribute("vehicles", vehicleSvc.findAll());
        return "vehicles";
    }
}
