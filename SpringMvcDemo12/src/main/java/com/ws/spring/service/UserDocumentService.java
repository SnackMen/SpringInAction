package com.ws.spring.service;

import com.ws.spring.model.UserDocument;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public interface UserDocumentService {
    UserDocument findById(int id);
    List<UserDocument> findAll();
    List<UserDocument> findAllByUserId(int id);
    void saveDocument(UserDocument document);
    void deleteById(int id);
}
