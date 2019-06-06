package com.webprogramiranje.Project.service;

import com.webprogramiranje.Project.exceptions.AdMissingParameterException;
import com.webprogramiranje.Project.exceptions.AdPriceNotDefinedException;
import com.webprogramiranje.Project.model.Ad;
import com.webprogramiranje.Project.model.RequestBody.AdForm;
import com.webprogramiranje.Project.model.User;
import com.webprogramiranje.Project.peristance.AdRepository;
import com.webprogramiranje.Project.peristance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.calendar.BaseCalendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;


    public Ad saveAd(AdForm adForm) throws AdMissingParameterException, AdPriceNotDefinedException {
        Ad newad = new Ad();
        checkAdFrom(adForm);
        newad.setDescription(adForm.getDescription());
        newad.setPrice(adForm.getPrice());
        newad.setTitle(adForm.getTitle());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = dtf.format(LocalDateTime.now());
        newad.setDateCreated(now);

        Optional<User> actual = userRepository.findById(adForm.getUserId());
        actual.get().getAdList().add(newad);

        newad.setUser(actual.get());

        //userRepository.save(actual.get());
        return adRepository.save(newad);
    }

    private void checkAdFrom(AdForm adForm) throws AdMissingParameterException, AdPriceNotDefinedException {
        if(adForm.getDescription().equals(""))
            throw new AdMissingParameterException("Missing parameter description");
        if(adForm.getPrice()<=0)
            throw new AdPriceNotDefinedException("Price missing");
        if(adForm.getTitle().equals(""))
            throw new AdMissingParameterException("Missing parameter title");
    }

    public List<Ad> findAll() {
        return adRepository.findAll();
    }
}
