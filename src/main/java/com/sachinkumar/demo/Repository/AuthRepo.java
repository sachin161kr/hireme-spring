package com.sachinkumar.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachinkumar.demo.Models.User;

@Repository
public interface AuthRepo extends JpaRepository<User, Integer> {

}
