package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.OrderDAO;
import com.xxbg.jbapi.db.dao.impl.OrderDAOImpl;
import com.xxbg.jbapi.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class OrderService {
    static Logger logger= LogManager.getLogger(OrderService.class);

    private OrderDAO orderDAO;
    public OrderService(){
        orderDAO=new OrderDAOImpl();
    }

    public int addOrder(Order order){
        return orderDAO.insertOrder(order);
    }
    public boolean updateOrder(Order order){
        return orderDAO.updateOrder(order);
    }
    public List<Order> getOrdersByUserId(int userId){
        return orderDAO.getOrdersByUserId(userId);
    }
}
