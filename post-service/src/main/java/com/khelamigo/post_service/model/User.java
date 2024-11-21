package com.khelamigo.post_service.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

import java.util.List;

@Node
@Data
public class User {
    @Id
    private Long id;

    @Relationship(type = "POSTED", direction = Relationship.Direction.OUTGOING)
    private List<Post> posts;

    @Relationship(type = "LIKED", direction = Relationship.Direction.OUTGOING)
    private List<Post> likedPosts;
}
