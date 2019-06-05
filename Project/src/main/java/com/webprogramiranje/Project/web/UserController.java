package com.webprogramiranje.Project.web;

import com.webprogramiranje.Project.model.User;
import com.webprogramiranje.Project.model.UserForm;
import com.webprogramiranje.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/saveUser")
    User saveUser(@RequestBody UserForm userForm){
        return userService.saveUser(userForm);
    }
}
