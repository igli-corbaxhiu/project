package com.lhind.project.service;

import com.lhind.project.model.User;

public interface UserService {

    void saveUser(User user);

    boolean isUserAlreadyPresent(User user);
}
