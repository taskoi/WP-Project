package com.webprogramiranje.Project.model.RequestBody;

import java.sql.Timestamp;

public class AdForm {

    private String title;

    private String description;

    private Double price;

    private Long userId;

    public AdForm(){

    }

    public AdForm(String title, String description, Double price,Long userId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
