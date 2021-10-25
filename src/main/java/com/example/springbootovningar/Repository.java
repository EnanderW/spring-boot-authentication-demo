package com.example.springbootovningar;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    private Map<String, User> users = new HashMap<>();

    public User get(String username) {
        return users.get(username.toLowerCase());
    }

    public void save(User user) {
        users.put(user.getName().toLowerCase(), user);
    }

}
