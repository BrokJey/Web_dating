package org.example.controller;

import org.example.model.User;
import org.example.service.MatchService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<User>> findMatches(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        List<User> matches = matchService.findMatches(user);
        return ResponseEntity.ok(matches);
    }
}
