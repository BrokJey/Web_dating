package org.example.repository;

import org.example.model.Match;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryMatchRepository implements MatchRepository {
    private final Map<Long, Match> matches = new HashMap<>();
    private long idCounter = 1;

    @Override
    public void save(Match match) {
        if (match.getId() == null) {
            match.setId(idCounter++);
        }
        matches.put(match.getId(), match);
    }

    @Override
    public List<Match> findByUserId(Long userId) {
        return matches.values().stream()
                .filter(m -> m.getUserId1().equals(userId) || m.getUserId2().equals(userId))
                .collect(Collectors.toList());
    }
}
