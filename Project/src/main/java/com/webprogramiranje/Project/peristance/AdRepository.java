package com.webprogramiranje.Project.peristance;

import com.webprogramiranje.Project.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

}
