package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.CheckoutDAO;
import com.xxbg.jbapi.db.dao.impl.CheckoutDAOImpl;
import com.xxbg.jbapi.entity.Checkout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class CheckoutService {
    static Logger logger= LogManager.getLogger(CheckoutService.class);

    private CheckoutDAO checkoutDAO;
    public CheckoutService(){
        checkoutDAO=new CheckoutDAOImpl();
    }

    public int addCheckout(Checkout checkout){
        return checkoutDAO.insertCheckout(checkout);
    }

    public boolean deleteCheckoutById(int id){
        return checkoutDAO.deleteCheckoutById(id);
    }

    public boolean updateCheckout(Checkout checkout){
        return checkoutDAO.updateCheckout(checkout);
    }

    public Checkout getCheckoutById(int id){
        return checkoutDAO.getCheckoutById(id);
    }
}
