package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ExpressAddressDAO;
import com.xxbg.jbapi.db.dao.impl.ExpressAddressDAOImpl;
import com.xxbg.jbapi.entity.ExpressAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class ExpressAddressService {
    static Logger logger= LogManager.getLogger(ExpressAddressService.class);

    private ExpressAddressDAO expressAddressDAO;

    public ExpressAddressService(){
        expressAddressDAO=new ExpressAddressDAOImpl();
    }

    public int addExpressAddress(ExpressAddress expressAddress){
        return expressAddressDAO.insertExpressAddress(expressAddress);
    }
    public boolean updateExpressAddress(ExpressAddress expressAddress){
        return expressAddressDAO.updateExpressAddress(expressAddress);
    }
    public List<ExpressAddress> getExpressAddressesByUserId(int userId){
        return expressAddressDAO.getExpressAddressesByUserId(userId);
    }
}
