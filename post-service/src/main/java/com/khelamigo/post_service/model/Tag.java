package com.khelamigo.post_service.model;

import java.util.UUID;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;

@Node
@Data
public class Tag {
    
    @Id
    private String id;
    private String name;

    public Tag(){
        this.id = UUID.randomUUID().toString();
    }
}

