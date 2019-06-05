package com.webprogramiranje.Project.web;

import com.webprogramiranje.Project.exceptions.EmailNotValidException;
import com.webprogramiranje.Project.exceptions.UserMissingParameterException;
import com.webprogramiranje.Project.model.User;
import com.webprogramiranje.Project.model.RequestBody.UserForm;
import com.webprogramiranje.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    User saveUser(@RequestBody UserForm userForm) throws EmailNotValidException, UserMissingParameterException {
        return userService.saveUser(userForm);
    }
}
