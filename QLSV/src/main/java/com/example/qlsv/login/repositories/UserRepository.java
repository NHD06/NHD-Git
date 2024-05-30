package com.example.qlsv.login.repositories;

import com.example.qlsv.login.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
}
