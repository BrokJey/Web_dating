package org.example.model;

import java.util.List;

public class Admin extends User {
    public Admin(Long id, String name, String email, String password, List<String> interests) {
        super(id, name, email, password, interests);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
