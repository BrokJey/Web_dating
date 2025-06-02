package org.example.service;

import org.example.model.RegularUser;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserServiceImplTest {

    @Test
    public void testRegisterUser() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        RegularUser user = (RegularUser) userService.register("Alice", "alice@mail.com", "pass123", List.of("music", "books"));

        assertNotNull(user);
        assertEquals("Alice", user.getName());
        verify(userRepository, times(1)).save(user);
    }
}