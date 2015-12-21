package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ProductLikeService;
import com.xxbg.jbapi.entity.ProductLike;
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
    public ProductLikeController(){
        productLikeService=new ProductLikeService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> updateProductLike(@RequestBody ProductLike productLike){
        logger.info("POST /productLikes, updateProductLike(),  productId="+productLike.getProductId()+",userId="+productLike.getUserId()+",status="+productLike.getStatus());
        HashMap hashMap=new HashMap();
        try{
            if(productLikeService.updateProductLike(productLike.getProductId(),productLike.getUserId(),productLike.getStatus())){
                hashMap.put("message","ok");
                return new ResponseEntity<>(hashMap, HttpStatus.OK);
            }else{
                hashMap.put("errorMessage","error");
                return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            logger.error("/products"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
