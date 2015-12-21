package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ProductCommentDAO;
import com.xxbg.jbapi.db.dao.impl.ProductCommentDAOImpl;
import com.xxbg.jbapi.entity.ProductComment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by yanli6 on 12/13/15.
 */
public class ProductCommentService {
    static Logger logger= LogManager.getLogger(ProductCommentService.class);

    private ProductCommentDAO productCommentDAO;

    public ProductCommentService(){
        productCommentDAO=new ProductCommentDAOImpl();
    }

    public int addProductComment(ProductComment productComment){
        return productCommentDAO.insertProductComment(productComment);
    }

    public List<ProductComment> getProductComments(int productId){
        try{
            return productCommentDAO.getCommentsByProductId(productId);
        }catch(Exception e){
            return null;
        }
    }
}
