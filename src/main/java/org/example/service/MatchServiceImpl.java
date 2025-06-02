package org.example.service;

import org.example.model.User;
import org.example.patterns.MatchStrategy;
import org.example.repository.UserRepository;
import org.example.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final UserRepository userRepository;
    private MatchStrategy matchStrategy;

    public MatchServiceImpl(UserRepository userRepository, MatchStrategy matchStrategy) {
        this.userRepository = userRepository;
        this.matchStrategy = matchStrategy;
    }

    @Override
    public List<User> findMatches(User user) {
        List<User> allUsers = userRepository.findAll();
        return matchStrategy.findMatches(user, allUsers);
    }

    public void setMatchStrategy(MatchStrategy matchStrategy) {
        this.matchStrategy = matchStrategy;
    }
}
