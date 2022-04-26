package com.memories.springboard.Controller.Api;


import com.memories.springboard.Dto.ResponseDto;
import com.memories.springboard.Entity.User;
import com.memories.springboard.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        int result = userService.회원가입(user);
        System.out.println("save호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user){
        userService.회원수정(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }
}
