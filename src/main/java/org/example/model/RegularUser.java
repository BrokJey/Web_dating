package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegularUser extends User {
    public RegularUser() {
        super();
    }

    public RegularUser(Long id, String name, String email, String password, List<String> interests) {
        super(id, name, email, password, interests);
    }

    @Override
    public String getRole() {
        return "RegularUser";
    }
}
