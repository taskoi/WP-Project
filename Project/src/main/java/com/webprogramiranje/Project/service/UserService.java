package com.webprogramiranje.Project.service;


import com.webprogramiranje.Project.exceptions.EmailNotValidException;
import com.webprogramiranje.Project.exceptions.UserMissingParameterException;
import com.webprogramiranje.Project.model.User;
import com.webprogramiranje.Project.model.RequestBody.UserForm;
import com.webprogramiranje.Project.peristance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(UserForm userForm) throws EmailNotValidException, UserMissingParameterException {
        User newU = new User();
        checkUserForm(userForm);
        newU.setFirstName(userForm.getFirstName());
        newU.setLastName(userForm.getLastName());
        newU.setPassword(userForm.getPassword());
        newU.setUsername(userForm.getUsername());
        newU.setEmail(userForm.getEmail());
       // System.out.println(newU.getFirstName() + " " + newU.getLastName());
        return userRepository.save(newU);
    }

    private void checkUserForm(UserForm userForm) throws UserMissingParameterException, EmailNotValidException {
        if(userForm.getEmail().equals(""))
            throw new UserMissingParameterException("Missing parameter email");
        if(!isValidEmail(userForm.getEmail()))
            throw new EmailNotValidException("Email not valid");
        if(userForm.getFirstName().equals(""))
            throw new UserMissingParameterException("Missing parameter first name");
        if(userForm.getLastName().equals(""))
            throw new UserMissingParameterException("Missing parameter last name");
        if(userForm.getPassword().equals(""))
            throw new UserMissingParameterException("Missing parameter password");
    }

    private boolean isValidEmail(String email){
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
