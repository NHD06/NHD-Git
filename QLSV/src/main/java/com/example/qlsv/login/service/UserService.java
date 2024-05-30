package com.example.qlsv.login.service;

import com.example.qlsv.login.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);

    User save(User entity);

    List<User> saveAll(List<User> entities);

    Optional<User> findById(String id);

    boolean existsById(String id);

    List<User> findAll();

    List<User> findAllById(List<String> ids);

    long count();

    void deleteById(String id);

    void delete(User entity);

    void deleteAllById(List<String> ids);

    void deleteAll(List<User> entities);

    void deleteAll();

    boolean checkLogin(String username, String password);
}
