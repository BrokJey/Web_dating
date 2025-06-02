package org.example.repository;

import org.example.model.Match;

import java.util.List;

public interface MatchRepository {
    void save(Match match);
    List<Match> findByUserId(Long userId);
}