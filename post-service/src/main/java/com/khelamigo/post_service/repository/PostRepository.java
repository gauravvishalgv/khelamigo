package com.khelamigo.post_service.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.khelamigo.post_service.model.Post;

import java.util.List;

public interface PostRepository extends Neo4jRepository<Post, String> {

   List<Post> findAll();

   List<Post> findByUserId(Long userId);
    
   @Query("""
      MATCH (p:Post {id: $postId})
      OPTIONAL MATCH (p)-[:HAS_COMMENT]->(c:Comment)
      OPTIONAL MATCH (cReply:Comment)-[:REPLIED_TO*]->(nestedReply:Comment)
      OPTIONAL MATCH (p)-[:LIKED_BY]->(:User)
      OPTIONAL MATCH (p)-[:HAS_MEDIA]->(media:Media)
      DETACH DELETE p, c, cReply, nestedReply, media
      """)
    void deletePostWithAllAssociations(String postId);


}
