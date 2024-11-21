package com.khelamigo.post_service.service;

import com.khelamigo.post_service.model.Comment;
import com.khelamigo.post_service.model.Post;
import com.khelamigo.post_service.model.User;
import com.khelamigo.post_service.repository.CommentRepository;
import com.khelamigo.post_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment addCommentToPost(String postId, String commentString, Long userId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isEmpty()) {
            throw new IllegalArgumentException("Post not found with ID: " + postId);
        }

        Comment comment = new Comment();
        comment.setContent(commentString);
        User user = new User();
        user.setId(userId);
        comment.setUser(user);

        Post post = postOptional.get();
        comment.setCreatedAt(LocalDateTime.now());
        comment = commentRepository.save(comment);

        post.getComments().add(comment);
        postRepository.save(post);

        return comment;
    }

    public Comment addReplyToComment(String commentId, String replyString, Long userId) {

        Optional<Comment> parentCommentOptional = commentRepository.findById(commentId);
        if (parentCommentOptional.isEmpty()) {
            throw new IllegalArgumentException("Comment not found with ID: " + commentId);
        }

        Comment comment = new Comment();
        comment.setContent(replyString);
        User user = new User();
        user.setId(userId);
        comment.setUser(user);

        Comment parentComment = parentCommentOptional.get();
        comment.setParentComment(parentComment);
        return commentRepository.save(comment);
    }
}
