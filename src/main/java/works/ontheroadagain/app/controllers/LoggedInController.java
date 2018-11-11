package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.Vehicle;

import java.util.ArrayList;

@Controller
public class LoggedInController {
    @GetMapping("/customerloggedin")
    public String UserLoggedIn (ModelMap model){
        User user = new User();
        user.setUsername("mstrezishar");

        user.setVehicles(new ArrayList<Vehicle>());
        model.addAttribute("user", user);
        return "/customerloggedin";


    }
}
