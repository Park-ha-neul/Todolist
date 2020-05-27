package com.tdl.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class calenderController {

    @GetMapping("/calender")
    public String calender(){
        return "calender";
    }
}
