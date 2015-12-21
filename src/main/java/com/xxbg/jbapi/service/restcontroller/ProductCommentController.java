package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ProductCommentService;
import com.xxbg.jbapi.entity.ProductComment;
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
@RequestMapping("/productComments")
public class ProductCommentController {
    static Logger logger= LogManager.getLogger(ProductCommentController.class);
    private ProductCommentService productCommentService;
    public ProductCommentController(){
        productCommentService=new ProductCommentService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> addProductComment(@RequestBody ProductComment productComment){
        logger.info("POST /productComments, addProductComment(),  productId="+productComment.getProductId()+",userId="+productComment.getUserId()+",commentContent="+productComment.getCommentContent());
        HashMap hashMap=new HashMap();
        try{
            int id=productCommentService.addProductComment(productComment);
            if(id>0){
                hashMap.put("id",id);
                return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
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
