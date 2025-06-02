package org.example.repository;

import org.example.model.User;
import java.util.List;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
    List<User> findAll();
    User findById(Long id);
    List<User> findByInterests(List<String> interests);
}
