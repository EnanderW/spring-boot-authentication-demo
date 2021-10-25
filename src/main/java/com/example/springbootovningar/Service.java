package com.example.springbootovningar;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public User createUser(User user) {
        User existing = repository.get(user.getName());
        if (existing != null)
            return null;

        repository.save(user);
        return user;
    }

    public boolean authenticate(String username, String password) {
        User user = repository.get(username);
        if (user == null) return false;

        return user.getPassword().equals(password);
    }
}
