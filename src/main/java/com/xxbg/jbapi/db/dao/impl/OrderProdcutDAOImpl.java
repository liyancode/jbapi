package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.OrderProductDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.OrderProduct;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class OrderProdcutDAOImpl implements OrderProductDAO{
    @Override
    public int insertOrderProduct(OrderProduct orderProduct) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderProductDAO orderProductDAO=sqlSession.getMapper(OrderProductDAO.class);
            orderProductDAO.insertOrderProduct(orderProduct);
            sqlSession.commit();
            return orderProduct.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateOrderProduct(OrderProduct orderProduct) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderProductDAO orderProductDAO=sqlSession.getMapper(OrderProductDAO.class);
            orderProductDAO.updateOrderProduct(orderProduct);
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
    public List<OrderProduct> getOrderProductsByOrderId(int orderId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderProductDAO orderProductDAO=sqlSession.getMapper(OrderProductDAO.class);
            return orderProductDAO.getOrderProductsByOrderId(orderId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
