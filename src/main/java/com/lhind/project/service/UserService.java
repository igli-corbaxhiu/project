package com.lhind.project.service;

import com.lhind.project.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    boolean isUserAlreadyPresent(User user);
    List<User> findAll();
    User findById(int id);
}
