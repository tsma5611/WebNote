package com.example.webnote.services;

import com.example.webnote.models.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    User save(User user);

    List<User> saveAll(List<User> users);
}
