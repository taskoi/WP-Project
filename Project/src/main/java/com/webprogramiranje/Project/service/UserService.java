package com.webprogramiranje.Project.service;


import com.webprogramiranje.Project.peristance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
}
