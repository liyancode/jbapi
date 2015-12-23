package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.PaymentTypeDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.PaymentType;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
public class PaymentTypeDAOImpl implements PaymentTypeDAO{
    @Override
    public int insertPaymentType(PaymentType paymentType) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            PaymentTypeDAO paymentTypeDAO=sqlSession.getMapper(PaymentTypeDAO.class);
            paymentTypeDAO.insertPaymentType(paymentType);
            sqlSession.commit();
            return paymentType.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deletePaymentTypeById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            PaymentTypeDAO paymentTypeDAO=sqlSession.getMapper(PaymentTypeDAO.class);
            paymentTypeDAO.deletePaymentTypeById(id);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updatePaymentType(PaymentType paymentType) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            PaymentTypeDAO paymentTypeDAO=sqlSession.getMapper(PaymentTypeDAO.class);
            paymentTypeDAO.updatePaymentType(paymentType);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public PaymentType getPaymentTypeById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            PaymentTypeDAO paymentTypeDAO=sqlSession.getMapper(PaymentTypeDAO.class);
            return paymentTypeDAO.getPaymentTypeById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            PaymentTypeDAO paymentTypeDAO=sqlSession.getMapper(PaymentTypeDAO.class);
            return paymentTypeDAO.getAllPaymentTypes();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
