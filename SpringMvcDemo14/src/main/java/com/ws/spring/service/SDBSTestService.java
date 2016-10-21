package com.ws.spring.service;


import com.ws.spring.model.SDBSCollectionModel;

/**
 * Created by laowang on 16-10-21.
 */
public interface SDBSTestService {
    SDBSCollectionModel findBySdbsNo(int sdbsno);
}
