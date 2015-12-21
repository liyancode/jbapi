package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.Checkout;

/**
 * Created by yanli6 on 12/2/15.
 */
public interface CheckoutDAO {
    /**
     * @return generated primary key (id)
     * */
    int insertCheckout(Checkout checkout);
    boolean deleteCheckoutById(int id);
    boolean updateCheckout(Checkout checkout);
    Checkout getCheckoutById(int id);
}
