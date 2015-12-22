package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ShoppingCartDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ShoppingCart;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by {liyan.code@gmail.com} on 12/22/15.
 */
public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    @Override
    public int insertShoppingCart(ShoppingCart shoppingCart) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartDAO shoppingCartDAO=sqlSession.getMapper(ShoppingCartDAO.class);
            shoppingCartDAO.insertShoppingCart(shoppingCart);
            sqlSession.commit();
            return shoppingCart.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateShoppingCart(ShoppingCart shoppingCart) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartDAO shoppingCartDAO=sqlSession.getMapper(ShoppingCartDAO.class);
            shoppingCartDAO.updateShoppingCart(shoppingCart);
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
    public ShoppingCart getShoppingCartByUserId(int userId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartDAO shoppingCartDAO=sqlSession.getMapper(ShoppingCartDAO.class);
            return shoppingCartDAO.getShoppingCartByUserId(userId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
