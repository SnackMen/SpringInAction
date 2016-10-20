package com.ws.spring.dao;

import com.ws.spring.model.UserDocument;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public class UserDocumentDaoImpl extends AbstractDao<Integer,UserDocument> implements UserDocumentDao {
    @SuppressWarnings("unckecked")
    @Override
    public List<UserDocument> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<UserDocument>)crit.list();
    }

    @Override
    public UserDocument findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(UserDocument document) {
        persist(document);
    }

    @SuppressWarnings("unckecked")
    @Override
    public List<UserDocument> findAllByUserId(int userId) {
        Criteria criteria = createEntityCriteria();
        Criteria userCriteria = criteria.createCriteria("user");
        userCriteria.add(Restrictions.eq("id",userId));
        return (List<UserDocument>)criteria.list();
    }

    @Override
    public void deleteById(int id) {
        UserDocument userDocument = getByKey(id);
        delete(userDocument);
    }
}
