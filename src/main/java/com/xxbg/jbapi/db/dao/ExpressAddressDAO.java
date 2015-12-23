package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ExpressAddress;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public interface ExpressAddressDAO {
    int insertExpressAddress(ExpressAddress expressAddress);
    boolean updateExpressAddress(ExpressAddress expressAddress);
    List<ExpressAddress> getExpressAddressesByUserId(int userId);
}
