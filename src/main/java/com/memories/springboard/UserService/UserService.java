package com.memories.springboard.UserService;


import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void save(User user){
        userRepo.save(user);
    }

    public List<User> showAll(){
        return (List<User>)userRepo.findAll();
    }



}
