package com.memories.springboard.User;

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
}
