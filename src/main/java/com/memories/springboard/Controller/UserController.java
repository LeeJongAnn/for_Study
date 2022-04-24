package com.memories.springboard.Controller;

import com.memories.springboard.Entity.User;
import com.memories.springboard.UserService.UserService;
import com.memories.springboard.config.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Home")
    public String viewHomePage(@AuthenticationPrincipal PrincipalDetail principal) {
        System.out.println(principal.getUsername());
        return "Home";
    }


    @GetMapping("/index/{count}")
    public String firstviewPage(@AuthenticationPrincipal PrincipalDetail principal,Model model,@PathVariable int count) {
        Page<User> listAll = userService.showAll(count);
        List<User> everyUser = listAll.getContent();
        model.addAttribute("everyPage",listAll.getTotalPages());
        model.addAttribute("List", everyUser);
        return "index";

    }

    @GetMapping("/auth/joinForm")
    public String joinviewPage() {
        return "join_form";
    }

    @GetMapping("/auth/loginForm")
    public String loginviewPage() {
        return "login_form";
    }


}
