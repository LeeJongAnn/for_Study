package com.memories.springboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping("/index")
    public String firstviewPage(){
        return "index";
    }

    @GetMapping("/join_form")
    public String joinviewPage(){
        return "join_form";
    }

    @GetMapping("/login_form")
    public String loginviewPage(){
        return "login_form";
    }
}
