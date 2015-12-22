package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ProductDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.Product;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 11/30/15.
 * for SqlSession is not thread safe, just keep its scope within method
 */
public class ProductDAOImpl implements ProductDAO {

    static Logger logger= LogManager.getLogger(ProductDAOImpl.class);

    @Override
    public int insertProduct(Product product) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.insertProduct(product);
            sqlSession.commit();
            return product.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deleteProductById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.deleteProductById(id);
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
    public boolean updateProduct(Product product) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.updateProduct(product);
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
    public Product getProductById(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            return productDAO.getProductById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProducts(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProducts(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByCategoryId(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByCategoryId(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByCategoryIdAndStatus(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByCategoryIdAndStatus(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByCategoryIdAndSort(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByCategoryIdAndSort(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByCategoryIdAndStatusAndSort(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByCategoryIdAndStatusAndSort(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByStatus(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByStatus(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsByStatusAndSort(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsByStatusAndSort(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Product> getProductsBySort(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            List<Product> productList=productDAO.getProductsBySort(hashMap);
            return productList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean commentCountMinusOne(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.commentCountMinusOne(id);
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
    public boolean commentCountPlusOne(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.commentCountPlusOne(id);
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
    public boolean likeCountMinusOne(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.likeCountMinusOne(id);
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
    public boolean likeCountPlusOne(int id) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductDAO productDAO=sqlSession.getMapper(ProductDAO.class);
            productDAO.likeCountPlusOne(id);
            sqlSession.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }
}
