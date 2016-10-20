package com.ws.spring.service;

import com.ws.spring.dao.UserDao;
import com.ws.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findBySSO(String sso) {
        User user = dao.findBySSO(sso);
        return user;
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */

    @Override
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setFirstName(user.getFirstName());
            entity.setEmail(user.getEmail());
            entity.setLastName(user.getLastName());
            entity.setUserDocuments(user.getUserDocuments());
        }
    }

    @Override
    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
