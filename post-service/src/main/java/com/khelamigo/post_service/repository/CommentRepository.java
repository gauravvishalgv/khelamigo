package com.khelamigo.post_service.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.khelamigo.post_service.model.Comment;

public interface CommentRepository extends Neo4jRepository<Comment, String> {

    List<Comment> findByParentCommentId(String parentCommentId);
    
}
