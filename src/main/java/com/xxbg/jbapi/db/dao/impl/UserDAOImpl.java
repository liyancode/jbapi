package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.UserDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.User;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by yanli6 on 12/16/15.
 */
public class UserDAOImpl implements UserDAO{
    @Override
    public int insertUser(User user) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
            userDAO.insertUser(user);
            sqlSession.commit();
            return user.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public User getUserById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
            return userDAO.getUserById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public User getUserByUsername(String userName) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
            return userDAO.getUserByUsername(userName);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            UserDAO userDAO=sqlSession.getMapper(UserDAO.class);
            return userDAO.getUserByEmail(email);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
