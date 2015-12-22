package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ProductLikeService;
import com.xxbg.jbapi.db.service.ProductService;
import com.xxbg.jbapi.entity.ProductLike;
import com.xxbg.jbapi.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by yanli6 on 12/21/15.
 */
@RestController
@RequestMapping("/productLikes")
public class ProductLikeController {
    static Logger logger= LogManager.getLogger(ProductLikeController.class);
    private ProductLikeService productLikeService;
    private ProductService productService;
    public ProductLikeController(){
        productLikeService=new ProductLikeService();
        productService=new ProductService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> updateProductLike(@RequestBody ProductLike productLike){
        logger.info("POST /productLikes, updateProductLike(),  productId="+productLike.getProductId()+",userId="+productLike.getUserId()+",status="+productLike.getStatus());
        HashMap hashMap=new HashMap();
        try{
            int product_id=productLike.getProductId();
            int status=productLike.getStatus();
            boolean countUpdate=false;
            if(productLikeService.updateProductLike(product_id,productLike.getUserId(),status)){
                hashMap.put("update product_ike","ok");
                if(status== Util.PRODUCT_LIKE_STATUS_ACTIVE){
                    countUpdate = productService.updateLikeCount(product_id,Util.PLUS);
                }else if(status== Util.PRODUCT_LIKE_STATUS_INACTIVE){
                    countUpdate = productService.updateLikeCount(product_id,Util.MINUS);
                }
                if(countUpdate){
                    hashMap.put("update product.like_count","ok");
                }else{
                    hashMap.put("update product.like_count","fail");
                }
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }else{
                hashMap.put("update product_ike","fail");
                hashMap.put("update product.like_count","fail");
                return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            logger.error("/products"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
