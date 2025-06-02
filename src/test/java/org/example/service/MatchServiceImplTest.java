package org.example.service;

import org.example.model.RegularUser;
import org.example.model.User;
import org.example.patterns.InterestBasedStrategy;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MatchServiceImplTest {

    @Test
    public void testFindMatches() {
        UserRepository userRepo = mock(UserRepository.class);
        MatchService matchService = new MatchServiceImpl(userRepo, new InterestBasedStrategy());

        RegularUser user1 = new RegularUser(1L, "Anna", "anna@mail.com", "123", List.of("books", "sports"));
        RegularUser user2 = new RegularUser(2L, "Bob", "bob@mail.com", "456", List.of("books", "music"));
        RegularUser user3 = new RegularUser(3L, "Cara", "cara@mail.com", "789", List.of("travel"));

        when(userRepo.findAll()).thenReturn(List.of(user1, user2, user3));

        List<User> matches = matchService.findMatches(user1);

        assertEquals(1, matches.size());
        assertEquals("Bob", matches.get(0).getName());
    }


}
