package com.khelamigo.post_service.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Node
@Data
public class Post {
    @Id
    private String id;
    private String content;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;

    @Relationship(type = "POSTED_BY", direction = Relationship.Direction.INCOMING)
    private User user;

    @Relationship(type = "HAS_COMMENT", direction = Relationship.Direction.OUTGOING)
    private List<Comment> comments;

    @Relationship(type = "HAS_MEDIA", direction = Relationship.Direction.OUTGOING)
    private List<Media> media;

    @Relationship(type = "TAGGED_WITH", direction = Relationship.Direction.OUTGOING)
    private List<Tag> tags;

    @Relationship(type = "LIKED_BY", direction = Relationship.Direction.INCOMING)
    private List<User> likes;

    public Post(){
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}
