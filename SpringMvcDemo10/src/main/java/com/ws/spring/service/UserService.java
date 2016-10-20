package com.ws.spring.service;

import com.ws.spring.model.User;

import java.util.List;

/**
 * Created by laowang on 16-10-19.
 */
public interface UserService {
    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    void deleteAllUsers();
    public boolean isUserExit(User user);
}
