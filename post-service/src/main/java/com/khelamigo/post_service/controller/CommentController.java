package com.khelamigo.post_service.controller;

import com.khelamigo.post_service.model.Comment;
import com.khelamigo.post_service.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> addCommentToPost(@PathVariable String postId, @RequestParam String comment) {

        Long userId = 1L;

        Comment createdComment = commentService.addCommentToPost(postId, comment, userId);

        return ResponseEntity.ok(createdComment);
    }

    @PostMapping("/reply/{commentId}")
    public ResponseEntity<Comment> addReplyToComment(@PathVariable String commentId, @RequestParam String reply) {

        Long userId = 1L;

        Comment createdReply = commentService.addReplyToComment(commentId, reply, userId);
        return ResponseEntity.ok(createdReply);
    }

    @GetMapping("/reply/{parentCommentId}")
    public List<Comment> getReplies(@PathVariable String parentCommentId) {
        return commentService.getRepliesUnderComment(parentCommentId);
    }
}
