package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("TECHNICIAN")) {
            return "redirect:/technicians";
        }
        if (request.isUserInRole("ADVISOR")) {
            return "redirect:/advisor";
        }
        else {
            return "redirect:/profile";
        }
    }
}
