package com.webprogramiranje.Project.service;


import com.webprogramiranje.Project.model.User;
import com.webprogramiranje.Project.model.UserForm;
import com.webprogramiranje.Project.peristance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserForm userForm) {
        User newU = new User();
        newU.setFirstName(userForm.getFirstName());
        newU.setLastName(userForm.getLastName());
        newU.setPassword(userForm.getPassword());
        newU.setUsername(userForm.getUsername());

       // System.out.println(newU.getFirstName() + " " + newU.getLastName());
        return userRepository.save(newU);
    }
}
