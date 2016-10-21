package com.ws.spring.dao;

import com.ws.spring.model.SDBSCollectionModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by laowang on 16-10-21.
 */
@Repository
public class SDBSTestDaoImpl implements SDBSTestDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public SDBSCollectionModel findBySdbsNo(int sdbsno) {
        System.out.println("通过sdbsno进行查询");

        return null;
    }
}
