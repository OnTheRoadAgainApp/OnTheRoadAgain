package works.ontheroadagain.app.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import works.ontheroadagain.app.models.User;
import works.ontheroadagain.app.models.UserWithRoles;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {

        UserWithRoles currentUser = (UserWithRoles) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = currentUser.getUserRole();

        System.out.println(role);
        if (role.equals("TECHNICIAN")) {
            return "redirect:/technicians";
        }
        if (role.equals("ADVISOR")) {
            return "redirect:/advisor";
        }
        if (role.equals("CUSTOMER")) {
            return "redirect:/profile";
        }

        return "home";
    }
}
