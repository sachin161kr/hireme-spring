package com.sachinkumar.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachinkumar.demo.Models.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
