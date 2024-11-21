package com.khelamigo.post_service.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.khelamigo.post_service.model.User;

public interface UserRepository extends Neo4jRepository<User, Long> {
}
