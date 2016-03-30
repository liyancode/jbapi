package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.OrderService;
import com.xxbg.jbapi.entity.Order;
import com.xxbg.jbapi.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by {liyan.code@gmail.com} on 3/30/16.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    static Logger logger= LogManager.getLogger(OrderController.class);
    private OrderService orderService;

    public OrderController(){
        orderService=new OrderService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        HashMap hashMap=new HashMap();
        try{
            int id=orderService.addOrder(order);
            hashMap.put("order",orderService.getOrdersByUserId(id));
            return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("/orders"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
