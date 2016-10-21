package com.ws.spring.service;

import com.ws.spring.dao.SDBSTestDaoImpl;
import com.ws.spring.model.SDBSCollectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by laowang on 16-10-21.
 */
@Service
@Transactional("testService")
public class SDBSTestServiceImpl implements SDBSTestService {

    @Autowired
    SDBSTestDaoImpl sdbsTestDao;

    @Override
    public SDBSCollectionModel findBySdbsNo(int sdbsno) {
        sdbsTestDao = new SDBSTestDaoImpl();
        return sdbsTestDao.findBySdbsNo(sdbsno);
    }
}
