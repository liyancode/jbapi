package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ProductCategoryDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ProductCategory;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by {liyan.code@gmail.com} on 12/8/15.
 */
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
    @Override
    public int insertProductCategory(ProductCategory productCategory) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductCategoryDAO productCategoryDAO=sqlSession.getMapper(ProductCategoryDAO.class);
            productCategoryDAO.insertProductCategory(productCategory);
            sqlSession.commit();
            return productCategory.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deleteProductCategoryById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductCategoryDAO productCategoryDAO=sqlSession.getMapper(ProductCategoryDAO.class);
            productCategoryDAO.deleteProductCategoryById(id);
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
    public boolean updateProductCategory(ProductCategory productCategory) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductCategoryDAO productCategoryDAO=sqlSession.getMapper(ProductCategoryDAO.class);
            productCategoryDAO.updateProductCategory(productCategory);
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
    public ProductCategory getProductCategoryById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        System.out.println("dao 68: sqlSession");
        try{
            ProductCategoryDAO productCategoryDAO=sqlSession.getMapper(ProductCategoryDAO.class);
            return productCategoryDAO.getProductCategoryById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }
}
