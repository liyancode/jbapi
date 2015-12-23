package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.OrderDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.Order;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public int insertOrder(Order order) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderDAO orderDAO=sqlSession.getMapper(OrderDAO.class);
            orderDAO.insertOrder(order);
            sqlSession.commit();
            return order.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderDAO orderDAO=sqlSession.getMapper(OrderDAO.class);
            orderDAO.updateOrder(order);
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
    public List<Order> getOrdersByUserId(int userId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            OrderDAO orderDAO=sqlSession.getMapper(OrderDAO.class);
            return orderDAO.getOrdersByUserId(userId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
