package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ShoppingCartDAO;
import com.xxbg.jbapi.db.dao.impl.ShoppingCartDAOImpl;
import com.xxbg.jbapi.entity.ShoppingCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class ShoppingCartService {
    static Logger logger= LogManager.getLogger(ShoppingCartService.class);

    private ShoppingCartDAO shoppingCartDAO;
    public ShoppingCartService(){
        shoppingCartDAO=new ShoppingCartDAOImpl();
    }
    public int addShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartDAO.insertShoppingCart(shoppingCart);
    }

    public boolean updateShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartDAO.updateShoppingCart(shoppingCart);
    }

    public ShoppingCart getShoppingCartByUserId(int userId){
        return shoppingCartDAO.getShoppingCartByUserId(userId);
    }
}
