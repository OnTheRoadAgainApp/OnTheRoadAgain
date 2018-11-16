package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooController {

    @GetMapping("/directions")
    public String directions() {
        return "directions";
    }

    @GetMapping("/faq")
    public String faq(){
        return "faq";
    }
    @GetMapping("/contact")
    public String contact() {return "contact";}

}
                        