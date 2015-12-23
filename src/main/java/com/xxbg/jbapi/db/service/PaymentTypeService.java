package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.PaymentTypeDAO;
import com.xxbg.jbapi.db.dao.impl.PaymentTypeDAOImpl;
import com.xxbg.jbapi.entity.PaymentType;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class PaymentTypeService {
    private PaymentTypeDAO paymentTypeDAO;
    public PaymentTypeService(){
        paymentTypeDAO=new PaymentTypeDAOImpl();
    }
    public int addPaymentType(PaymentType paymentType){
        return paymentTypeDAO.insertPaymentType(paymentType);
    }
    public boolean updatePaymentType(PaymentType paymentType){
        return paymentTypeDAO.updatePaymentType(paymentType);
    }
    public List<PaymentType> getAllPaymentTypes(){
        return paymentTypeDAO.getAllPaymentTypes();
    }
}
