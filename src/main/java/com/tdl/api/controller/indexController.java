package com.tdl.api.controller;

import com.tdl.api.config.oauth.LoginUser;
import com.tdl.api.config.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {

    @GetMapping("/")
    public String index(Model model){


        return "index";
    }
}
