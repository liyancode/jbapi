package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ExpressAddressDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ExpressAddress;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class ExpressAddressDAOImpl implements ExpressAddressDAO {
    @Override
    public int insertExpressAddress(ExpressAddress expressAddress) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ExpressAddressDAO expressAddressDAO=sqlSession.getMapper(ExpressAddressDAO.class);
            expressAddressDAO.insertExpressAddress(expressAddress);
            sqlSession.commit();
            return expressAddress.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateExpressAddress(ExpressAddress expressAddress) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ExpressAddressDAO expressAddressDAO=sqlSession.getMapper(ExpressAddressDAO.class);
            expressAddressDAO.updateExpressAddress(expressAddress);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<ExpressAddress> getExpressAddressesByUserId(int userId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ExpressAddressDAO expressAddressDAO=sqlSession.getMapper(ExpressAddressDAO.class);
            return expressAddressDAO.getExpressAddressesByUserId(userId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
