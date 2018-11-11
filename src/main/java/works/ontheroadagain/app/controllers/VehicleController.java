package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;
import works.ontheroadagain.app.services.VehicleRepository;
import works.ontheroadagain.app.services.VehicleService;

@Controller
public class VehicleController {
//    private final VehicleService vehicleSvc;
    private final VehicleRepository vehicleRepo;

    public VehicleController(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    private final VehicleService vehicleSvc;

    public VehicleController(VehicleService vehicleSvc) {
        this.vehicleSvc = vehicleSvc;
    }

    @GetMapping("/vehicles")
    public String vehicles(Model m) {
        m.addAttribute("vehicles", vehicleRepo.findAll());
        return "/vehicles";
    }

    @GetMapping("/vehicles/add")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "/addVehicle";
    }

    @PostMapping("/vehicles/add")
    public String create(@ModelAttribute Vehicle vehicle) {
        vehicleRepo.save(vehicle);
        return "redirect:/vehicles";
        m.addAttribute("vehicles", vehicleSvc.findAll());
        return "vehicles";
    }
}
