package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    User register(String name, String email, String password, List<String> interests);
    User getUserById(Long id);
    List<User> getAllUsers();
}
