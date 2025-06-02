package org.example.patterns;

import org.example.model.User;

import java.util.List;

public interface MatchStrategy {
    List<User> findMatches(User user, List<User> candidates);
}
