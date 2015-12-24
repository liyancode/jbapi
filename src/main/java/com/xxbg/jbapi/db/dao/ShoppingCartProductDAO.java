package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ShoppingCartProduct;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/22/15.
 */
public interface ShoppingCartProductDAO {
    int insertShoppingCartProduct(ShoppingCartProduct shoppingCartProduct);
    boolean updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct);
    boolean deleteShoppingCartProductById(int id);
    List<ShoppingCartProduct> getByShoppingCartId(int shoppingCartId);
    int existedCount(ShoppingCartProduct shoppingCartProduct);
}
