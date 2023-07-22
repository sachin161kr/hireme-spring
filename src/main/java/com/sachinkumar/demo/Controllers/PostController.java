package com.sachinkumar.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachinkumar.demo.Models.Post;
import com.sachinkumar.demo.Repository.PostRepo;

@RestController
@RequestMapping("/posts")
@CrossOrigin(maxAge = 3600)
public class PostController {

    @Autowired
    PostRepo postRepo;

    @PostMapping("/addPost")
    public String addPost(@RequestBody Post post) {
        postRepo.save(post);
        return "Post Added";
    }

    @GetMapping("/allPosts")
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

}
