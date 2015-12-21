package com.xxbg.jbapi.db.dao.impl;

import com.xxbg.jbapi.db.dao.ProductCommentDAO;
import com.xxbg.jbapi.db.mybatis.MyBatis;
import com.xxbg.jbapi.entity.ProductComment;
import com.xxbg.jbapi.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by yanli6 on 12/13/15.
 */
public class ProductCommentDAOImpl implements ProductCommentDAO{

    @Override
    public List<ProductComment> getCommentsByProductId(int productId) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductCommentDAO productCommentDAO=sqlSession.getMapper(ProductCommentDAO.class);
            return productCommentDAO.getCommentsByProductId(productId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public int insertProductComment(ProductComment productComment) {
        SqlSession sqlSession=new MyBatis(Util.MYBATIS_XML).getSession();
        try{
            ProductCommentDAO productCommentDAO=sqlSession.getMapper(ProductCommentDAO.class);
            productCommentDAO.insertProductComment(productComment);
            sqlSession.commit();
            return productComment.getId();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return -1;
        }finally {
            sqlSession.close();
        }
    }
}
