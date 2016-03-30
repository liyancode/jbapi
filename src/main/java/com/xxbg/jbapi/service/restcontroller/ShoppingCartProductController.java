package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ShoppingCartProductService;
import com.xxbg.jbapi.db.service.ShoppingCartService;
import com.xxbg.jbapi.entity.ShoppingCart;
import com.xxbg.jbapi.entity.ShoppingCartProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/24/15.
 */
@RestController
@RequestMapping("/shoppingCartProducts")
public class ShoppingCartProductController {
    static Logger logger= LogManager.getLogger(ShoppingCartController.class);
    private ShoppingCartService shoppingCartService;
    private ShoppingCartProductService shoppingCartProductService;

    public ShoppingCartProductController(){
        shoppingCartService=new ShoppingCartService();
        shoppingCartProductService=new ShoppingCartProductService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> addShoppingCartProduct(@RequestBody ShoppingCartProduct shoppingCartProduct){
        HashMap hashMap=new HashMap();
        try{
            if(shoppingCartProductService.existed(shoppingCartProduct)){
                shoppingCartProductService.updateShoppingCartProduct(shoppingCartProduct);
            }else{
                shoppingCartProductService.addShoppingCartProduct(shoppingCartProduct);
            }
            hashMap.put("message","add shopping cart product ok.");
            return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("/shoppingCarts"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes="application/json")
    public ResponseEntity<?> updateShoppingCartProduct(@RequestBody ShoppingCartProduct shoppingCartProduct){
        HashMap hashMap=new HashMap();
        try{
            shoppingCartProductService.updateShoppingCartProduct(shoppingCartProduct);
            hashMap.put("message","update shopping cart product ok.");
            return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("/shoppingCarts"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{shoppingCartId}",method = RequestMethod.GET)
    public ResponseEntity<?> getAllByShoppingCartId(@PathVariable int shoppingCartId){
        HashMap hashMap=new HashMap();
        try{
            List<ShoppingCartProduct> list=shoppingCartProductService.getAllByShoppingCartId(shoppingCartId);
            hashMap.put("allList",list);
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }catch (Exception e){
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
