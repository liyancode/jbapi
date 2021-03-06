package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.OrderProductDAO;
import com.xxbg.jbapi.db.dao.impl.OrderProdcutDAOImpl;
import com.xxbg.jbapi.entity.OrderProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class OrderProductService {
    static Logger logger= LogManager.getLogger(OrderProductService.class);
    private OrderProductDAO orderProductDAO;
    public OrderProductService(){
        orderProductDAO=new OrderProdcutDAOImpl();
    }
    public int addOrderProduct(OrderProduct orderProduct){
        return orderProductDAO.insertOrderProduct(orderProduct);
    }
    public boolean updateOrderProduct(OrderProduct orderProduct){
        return orderProductDAO.updateOrderProduct(orderProduct);
    }
    public List<OrderProduct> getOrderProductsByOrderId(int orderId){
        return orderProductDAO.getOrderProductsByOrderId(orderId);
    }
}
