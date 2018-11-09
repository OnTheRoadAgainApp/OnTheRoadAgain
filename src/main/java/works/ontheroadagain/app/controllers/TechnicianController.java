package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TechnicianController {

    @GetMapping("/technicians")
    public String welcome() {
        return "/technicians";
    }
}
