package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ProductLikeDAO;
import com.xxbg.jbapi.db.dao.impl.ProductLikeDAOImpl;
import com.xxbg.jbapi.entity.ProductLike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yanli6 on 12/13/15.
 */
public class ProductLikeService {
    static Logger logger= LogManager.getLogger(ProductLikeService.class);

    private ProductLikeDAO productLikeDAO;

    public ProductLikeService(){
        productLikeDAO=new ProductLikeDAOImpl();
    }

    public List<ProductLike> getProductLikes(int productId){
        try{
            return productLikeDAO.getLikesByProductId(productId);
        }catch(Exception e){
            return null;
        }
    }

    public boolean updateProductLike(Integer productId,Integer userId,Integer status){
        HashMap hashMap=new HashMap();
        hashMap.put("productId",productId);
        hashMap.put("userId",userId);
        hashMap.put("status",status);
        try{
            if(productLikeDAO.countProductLikeByProductidAndUserid(hashMap)>0){
                return productLikeDAO.updateStatus(hashMap);
            }else{
                return productLikeDAO.insertProductLike(new ProductLike(productId,userId,new Date(),status))>0;
            }
        }catch(Exception e){
            return false;
        }
    }
}
