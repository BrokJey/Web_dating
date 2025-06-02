package org.example.patterns;

import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterestBasedStrategy implements MatchStrategy {

    @Override
    public List<User> findMatches(User user, List<User> candidates) {
        List<User> matches = new ArrayList<>();
        for (User candidate : candidates) {
            if (!candidate.getId().equals(user.getId()) &&
                    !candidate.getInterests().isEmpty() &&
                    user.getInterests().stream().anyMatch(candidate.getInterests()::contains)) {
                matches.add(candidate);
            }
        }
        return matches;
    }
}