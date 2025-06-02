package org.example.service;

import org.example.model.User;

import java.util.List;

public interface MatchService {
    List<User> findMatches(User user);
}
