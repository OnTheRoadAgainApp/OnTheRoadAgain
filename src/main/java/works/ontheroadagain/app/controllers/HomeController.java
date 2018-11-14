package works.ontheroadagain.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import works.ontheroadagain.app.services.SmsSender;

@Controller
public class HomeController {
    private SmsSender smsSender;

    public HomeController (SmsSender smsSender){
        this.smsSender = smsSender;
    }
    @GetMapping("/")
    public String welcome() {
        SmsSender smsSender = new SmsSender();
        smsSender.sendText();
        return "home";
    }

}
