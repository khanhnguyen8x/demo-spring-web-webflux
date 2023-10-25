package com.example.demowebflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryReactive extends ReactiveMongoRepository<User, String> {
}