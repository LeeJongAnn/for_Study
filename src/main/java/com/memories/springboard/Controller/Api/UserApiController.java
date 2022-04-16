package com.memories.springboard.Controller.Api;


import com.memories.springboard.Dto.ResponseDto;
import com.memories.springboard.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("save호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
