package com.memories.springboard.Controller;

import com.memories.springboard.Entity.User;
import com.memories.springboard.UserService.UserService;
import com.memories.springboard.config.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
    @GetMapping("/user/updateForm")
    public String viewUpdateForm(@AuthenticationPrincipal PrincipalDetail principal,Model model) {
        System.out.println(principal.getUsername());
        return "updateForm";
    }

//    @GetMapping("/test")
//    public String classifyPage(@AuthenticationPrincipal PrincipalDetail principal,Model model){
//        return firstviewPage("email","asc",principal,model,1);
//    }

    @GetMapping("/index/{count}")
    public String firstviewPage(@Param("classify") String classify,@Param("Direction") String Direction, @AuthenticationPrincipal PrincipalDetail principal, Model model, @PathVariable int count) {


        System.out.println("classify : " + classify);
        System.out.println("Direction: " + Direction);

        Page<User> listAll = userService.showAll(count,classify,Direction);
        List<User> everyUser = listAll.getContent();
        String flip = Direction.equals("asc") ? "desc" : "asc";
        model.addAttribute("everyPage",listAll.getTotalPages());
        model.addAttribute("List", everyUser);
        model.addAttribute("nowPage",count);
        model.addAttribute("classify",classify);
        model.addAttribute("Direction",Direction);
        model.addAttribute("flip",flip);

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

    @GetMapping("/street")
    public String viewStreet() {
        return "index2";
    }

}
