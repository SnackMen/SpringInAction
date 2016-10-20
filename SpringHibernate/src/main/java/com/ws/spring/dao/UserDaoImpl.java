package com.ws.spring.dao;

import com.ws.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao {
    @Override
    public User findById(int id) {
        User user = getByKey(id);
        return user;
    }

    @Override
    public User findBySSO(String sso) {
        System.out.println("SSO :"+sso);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId",sso));
        User user = (User)criteria.uniqueResult();
        return user;
    }


    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        delete(user);

    }

    @SuppressWarnings("unckecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        return users;
    }
}
