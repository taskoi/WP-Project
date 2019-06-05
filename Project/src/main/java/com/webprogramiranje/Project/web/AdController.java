package com.webprogramiranje.Project.web;

import com.webprogramiranje.Project.exceptions.AdMissingParameterException;
import com.webprogramiranje.Project.exceptions.AdPriceNotDefinedException;
import com.webprogramiranje.Project.model.Ad;
import com.webprogramiranje.Project.model.RequestBody.AdForm;
import com.webprogramiranje.Project.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    @Autowired
    private AdService adService;

    @PostMapping("/saveAd")
    Ad saveAd(@RequestBody AdForm adForm) throws AdMissingParameterException, AdPriceNotDefinedException {
        return adService.saveAd(adForm);
    }

    @GetMapping("/allAds")
    List<Ad> adList(){
        return adService.findAll();
    }
}
