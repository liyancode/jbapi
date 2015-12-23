package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ShoppingCartProductDAO;
import com.xxbg.jbapi.db.dao.impl.ShoppingCartProductDAOImpl;
import com.xxbg.jbapi.entity.ShoppingCart;
import com.xxbg.jbapi.entity.ShoppingCartProduct;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class ShoppingCartProductService {
    private ShoppingCartProductDAO shoppingCartProductDAO;
    public ShoppingCartProductService(){
        shoppingCartProductDAO=new ShoppingCartProductDAOImpl();
    }
    public int addShoppingCartProduct(ShoppingCartProduct shoppingCartProduct){
        return shoppingCartProductDAO.insertShoppingCartProduct(shoppingCartProduct);
    }
    public boolean updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct){
        return shoppingCartProductDAO.updateShoppingCartProduct(shoppingCartProduct);
    }
    public List<ShoppingCartProduct> getAllByShoppingCartId(int shoppingCartId){
        return shoppingCartProductDAO.getByShoppingCartId(shoppingCartId);
    }
    public boolean deleteShoppingCartProductById(int id){
        return shoppingCartProductDAO.deleteShoppingCartProductById(id);
    }
}