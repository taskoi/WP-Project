package com.webprogramiranje.Project.peristance;

import com.webprogramiranje.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
