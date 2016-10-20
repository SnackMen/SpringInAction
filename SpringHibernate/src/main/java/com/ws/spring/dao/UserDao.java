package com.ws.spring.dao;

import com.ws.spring.model.User;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public interface UserDao {
    User findById(int id);
    User findBySSO(String sso);
    void save(User user);
    void deleteBySSO(String sso);
    List<User> findAllUsers();
}
