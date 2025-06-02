package org.example.service;

import org.example.model.User;
import org.example.patterns.UserFactory;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final AtomicLong idGenerator = new AtomicLong(1); // генератор ID

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String name, String email, String password, List<String> interests) {
        Long id = idGenerator.getAndIncrement();
        String type = "RegularUser"; // по умолчанию
        User user = UserFactory.createUser(type, id, name, email, password, interests);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
