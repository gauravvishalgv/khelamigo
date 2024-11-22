package com.khelamigo.post_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khelamigo.post_service.dto.PostRequestDto;
import com.khelamigo.post_service.model.Post;
import com.khelamigo.post_service.service.PostService;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/user/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {

        Long userId = 1L;

        return postService.createPost(postRequestDto, userId );
    }

    @PostMapping("/{postId}/like")
    public Post likePost(@PathVariable String postId) {

        Long userId = 1L;

        return postService.likePost(postId, userId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
