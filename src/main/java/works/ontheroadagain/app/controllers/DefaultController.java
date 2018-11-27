package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.models.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Long role = currentUser.getRole().getId();
        System.out.println(role);
        if (role.equals("TECHNICIAN")) {
            return "redirect:/technicians";
        }
        if (role.equals("ADVISOR")) {
            return "redirect:/advisor";
        }
        if (role.equals("CUSTOMERR")) {
            return "redirect:/profile";
        }

        return "/";
    }
}
