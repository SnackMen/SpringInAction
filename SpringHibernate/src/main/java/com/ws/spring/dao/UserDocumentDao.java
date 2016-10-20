package com.ws.spring.dao;

import com.ws.spring.model.UserDocument;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public interface UserDocumentDao {
    List<UserDocument> findAll();
    UserDocument findById(int id);
    void save(UserDocument document);
    List<UserDocument> findAllByUserId(int userId);
    void deleteById(int id);
}
