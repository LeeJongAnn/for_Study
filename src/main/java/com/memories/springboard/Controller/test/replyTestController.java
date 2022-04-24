package com.memories.springboard.Controller.test;


import com.memories.springboard.Entity.Reply;
import com.memories.springboard.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class replyTestController {

    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("/rest/test")
    public List<Reply> ReplyTest(){
        return replyRepository.findAll();
    }
}
