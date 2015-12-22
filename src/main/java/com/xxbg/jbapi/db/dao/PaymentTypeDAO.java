package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.PaymentType;

/**
 * Created by {liyan.code@gmail.com} on 12/2/15.
 */
public interface PaymentTypeDAO {
    int insertPaymentType(PaymentType paymentType);
    boolean deletePaymentTypeById(int id);
    boolean updatePaymentType(PaymentType paymentType);
    PaymentType getPaymentTypeById(int id);
}
