package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.CheckoutDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.Checkout;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by {liyan.code@gmail.com} on 12/2/15.
 */
public class CheckoutDAOImpl implements CheckoutDAO {
    @Override
    public int insertCheckout(Checkout checkout) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            CheckoutDAO checkoutDAO=sqlSession.getMapper(CheckoutDAO.class);
            checkoutDAO.insertCheckout(checkout);
            sqlSession.commit();
            return checkout.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deleteCheckoutById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            CheckoutDAO checkoutDAO=sqlSession.getMapper(CheckoutDAO.class);
            checkoutDAO.deleteCheckoutById(id);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateCheckout(Checkout checkout) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            CheckoutDAO checkoutDAO=sqlSession.getMapper(CheckoutDAO.class);
            checkoutDAO.updateCheckout(checkout);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public Checkout getCheckoutById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        System.out.println("dao 68: sqlSession");
        try{
            CheckoutDAO checkoutDAO=sqlSession.getMapper(CheckoutDAO.class);
            return checkoutDAO.getCheckoutById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
