package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.UserDAO;
import com.xxbg.jbapi.db.dao.impl.UserDAOImpl;
import com.xxbg.jbapi.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by yanli6 on 12/16/15.
 */
public class UserService {
    static Logger logger= LogManager.getLogger(UserService.class);

    private UserDAO userDAO;

    public UserService(){
        userDAO=new UserDAOImpl();
    }
    public int addUser(User user){
        return userDAO.insertUser(user);
    }

    public User getUserByUsername(String userName){
        return userDAO.getUserByUsername(userName);
    }
    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public User getUserById(int id){
        return userDAO.getUserById(id);
    }
}
