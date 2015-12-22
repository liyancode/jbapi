package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ShoppingCart;

/**
 * Created by {liyan.code@gmail.com} on 12/22/15.
 */
public interface ShoppingCartDAO {
    int insertShoppingCart(ShoppingCart shoppingCart);
    boolean updateShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCartByUserId(int userId);
}
