package com.ws.spring.dao;

import com.ws.spring.model.SDBSCollectionModel;

/**
 * Created by laowang on 16-10-21.
 */
public interface SDBSTestDao {
    SDBSCollectionModel findBySdbsNo(int sdbsno);

}
