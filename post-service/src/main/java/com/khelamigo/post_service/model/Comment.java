package com.khelamigo.post_service.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Node
@Data
public class Comment {
    @Id
    private String id;
    private String content;
    private LocalDateTime createdAt;

    @Relationship(type = "POSTED_BY", direction = Relationship.Direction.INCOMING)
    private User user;

    @Relationship(type = "REPLIED_TO", direction = Relationship.Direction.OUTGOING)
    private Comment parentComment;

    public Comment(){
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}
