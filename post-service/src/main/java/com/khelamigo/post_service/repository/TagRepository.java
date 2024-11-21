package com.khelamigo.post_service.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.khelamigo.post_service.model.Tag;

import java.util.Optional;

public interface TagRepository extends Neo4jRepository<Tag, String> {
    Optional<Tag> findByName(String name);
}
