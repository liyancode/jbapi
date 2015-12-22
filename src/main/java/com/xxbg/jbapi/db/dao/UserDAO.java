package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.User;

/**
 * Created by {liyan.code@gmail.com} on 12/16/15.
 */
public interface UserDAO {
    int insertUser(User user);
    User getUserById(int id);
    User getUserByUsername(String userName);
    User getUserByEmail(String email);
    boolean updateUser(User user);
}