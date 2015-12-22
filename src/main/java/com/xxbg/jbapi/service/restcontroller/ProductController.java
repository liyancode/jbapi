package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ProductCategoryService;
import com.xxbg.jbapi.db.service.ProductCommentService;
import com.xxbg.jbapi.db.service.ProductLikeService;
import com.xxbg.jbapi.db.service.ProductService;
import com.xxbg.jbapi.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by {liyan.code@gmail.com} on 12/1/15.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    static Logger logger= LogManager.getLogger(ProductController.class);
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private ProductCommentService productCommentService;
    private ProductLikeService productLikeService;

    public ProductController(){
        productService=new ProductService();
        productCategoryService=new ProductCategoryService();
        productCommentService=new ProductCommentService();
        productLikeService=new ProductLikeService();
    }

    /**
     * retrieve products
     * filter by request params
     * sort by param sort
     * */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<?> getProducts(
            @RequestParam(value = "category_id",required = false) Integer categoryId,
            @RequestParam(value = "status",required = false) Integer status,
            @RequestParam(value = "sort",required = false) String sort,
            @RequestParam(value = "page",required = true) Integer page){
        HashMap hashMap=new HashMap();
        try{
            if(categoryId!=null){
                hashMap.put("category",productCategoryService.getProductCategoryById(categoryId.intValue()));
            }else{
                hashMap.put("category","all");
            }
            hashMap.put("products", productService.getProducts(categoryId,status,sort,page));
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }catch(Exception e){
            logger.error("/products?categoryId="+categoryId+"&sort="+sort+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getProducts(@PathVariable int id){
        HashMap hashMap=new HashMap();
        try{
            hashMap.put("product",productService.getProductById(id));
            hashMap.put("comments",productCommentService.getProductComments(id));
            hashMap.put("likes",productLikeService.getProductLikes(id));
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }catch (Exception e){
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        HashMap hashMap=new HashMap();
        try{
            int id=productService.addProduct(product);
            hashMap.put("product",productService.getProductById(id));
            return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("/products"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
