package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ProductLikeDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ProductLike;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yanli6 on 12/13/15.
 */
public class ProductLikeDAOImpl implements ProductLikeDAO {

    @Override
    public List<ProductLike> getLikesByProductId(int productId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductLikeDAO productLikeDAO=sqlSession.getMapper(ProductLikeDAO.class);
            return productLikeDAO.getLikesByProductId(productId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public int insertProductLike(ProductLike productLike) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductLikeDAO productLikeDAO=sqlSession.getMapper(ProductLikeDAO.class);
            productLikeDAO.insertProductLike(productLike);
            sqlSession.commit();
            return productLike.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public int countProductLikeByProductidAndUserid(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductLikeDAO productLikeDAO=sqlSession.getMapper(ProductLikeDAO.class);
            return productLikeDAO.countProductLikeByProductidAndUserid(hashMap);
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean updateStatus(HashMap hashMap) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductLikeDAO productLikeDAO=sqlSession.getMapper(ProductLikeDAO.class);
            productLikeDAO.updateStatus(hashMap);
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
}

