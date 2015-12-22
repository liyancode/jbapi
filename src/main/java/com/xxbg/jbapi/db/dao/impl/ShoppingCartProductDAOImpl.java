package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ShoppingCartProductDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ShoppingCartProduct;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by yanli6 on 12/22/15.
 */
public class ShoppingCartProductDAOImpl implements ShoppingCartProductDAO {
    @Override
    public int insertShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartProductDAO shoppingCartProductDAO=sqlSession.getMapper(ShoppingCartProductDAO.class);
            shoppingCartProductDAO.insertShoppingCartProduct(shoppingCartProduct);
            sqlSession.commit();
            return shoppingCartProduct.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartProductDAO shoppingCartProductDAO=sqlSession.getMapper(ShoppingCartProductDAO.class);
            shoppingCartProductDAO.updateShoppingCartProduct(shoppingCartProduct);
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
    public boolean deleteShoppingCartProductById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartProductDAO shoppingCartProductDAO=sqlSession.getMapper(ShoppingCartProductDAO.class);
            shoppingCartProductDAO.deleteShoppingCartProductById(id);
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
    public List<ShoppingCartProduct> getByShoppingCartId(int shoppingCartId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ShoppingCartProductDAO shoppingCartProductDAO=sqlSession.getMapper(ShoppingCartProductDAO.class);
            return shoppingCartProductDAO.getByShoppingCartId(shoppingCartId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
