package com.ws.spring.service;

import com.ws.spring.model.User;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public interface UserService {
    User findById(int id);
    User findBySSO(String sso);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserBySSO(String sso);
    List<User> findAllUsers();
    boolean isUserSSOUnique(Integer id, String sso);
}
