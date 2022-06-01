package com.revature.Revamedia.beans.repositories;

import com.revature.Revamedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);


}
