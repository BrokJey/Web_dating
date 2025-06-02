package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    protected List<String> interests;

    public abstract String getRole();
}
