package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.Order;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public interface OrderDAO {
    int insertOrder(Order order);
    boolean updateOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
}
