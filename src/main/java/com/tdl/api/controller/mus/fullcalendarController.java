package com.tdl.api.controller.mus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fullcalendarController {

    @GetMapping("/fullcalendar")
    public String fullcalendar(){
        return "fullcalendar";
    }
}
