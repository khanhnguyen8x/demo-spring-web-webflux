package com.example.demowebflux;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final MongoTemplate mongoTemplate;
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }

    public User updateUser(String userId, User user) {
        var raw = userRepository.findById(userId);
        raw.ifPresent(dbUser -> {
            dbUser.setName(user.getName());
            dbUser.setDepartment(user.getDepartment());
            dbUser.setAge(user.getAge());
            dbUser.setSalary(user.getSalary());
            userRepository.save(dbUser);
        });
        return raw.orElse(null);
    }

    public User deleteUser(String userId) {
        var raw = userRepository.findById(userId);
        raw.ifPresent(userRepository::delete);
        return raw.orElse(null);
    }

    public User fetchUsers(String name) {
        Query query = new Query().with(Sort.by(Collections.singletonList(Sort.Order.asc("age"))));
        query.addCriteria(Criteria.where("name").regex(name));

        return mongoTemplate.findOne(query, User.class);
    }
}