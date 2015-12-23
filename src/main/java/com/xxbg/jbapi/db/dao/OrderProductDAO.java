package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.OrderProduct;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public interface OrderProductDAO {
    int insertOrderProduct(OrderProduct orderProduct);
    boolean updateOrderProduct(OrderProduct orderProduct);
    List<OrderProduct> getOrderProductsByOrderId(int orderId);
}
