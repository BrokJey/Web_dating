package org.example.patterns;

import org.example.model.*;

import java.util.List;

public class UserFactory {

    public static User createUser(String type, Long id, String name, String email, String password, List<String> interests) {
        if ("Admin".equalsIgnoreCase(type)) {
            return new Admin(id, name, email, password, interests);
        } else {
            return new RegularUser(id, name, email, password, interests);
        }
    }
}
