package com.memories.springboard.UserService;


import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public int 회원가입(User user) {
        try {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            user.setPassword(encPassword);
            user.setRole("USER");
            userRepo.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService: " + e.getMessage());
        }
    return -1;
    }
    public List<User> showAll(){
        return (List<User>)userRepo.findAll();
    }



}
