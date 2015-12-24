package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ShoppingCartProductService;
import com.xxbg.jbapi.db.service.ShoppingCartService;
import com.xxbg.jbapi.entity.ShoppingCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by {liyan.code@gmail.com} on 12/23/15.
 */
@RestController
@RequestMapping("/shoppingCarts")
public class ShoppingCartController {
    static Logger logger= LogManager.getLogger(ShoppingCartController.class);
    private ShoppingCartService shoppingCartService;
    private ShoppingCartProductService shoppingCartProductService;

    public ShoppingCartController(){
        shoppingCartService=new ShoppingCartService();
        shoppingCartProductService=new ShoppingCartProductService();
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        HashMap hashMap=new HashMap();
        try{
            shoppingCartService.addShoppingCart(shoppingCart);
            hashMap.put("shoppingCart",shoppingCartService.getShoppingCartByUserId(shoppingCart.getUserId()));
            return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("/shoppingCarts"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ResponseEntity<?> getShoppingCartByUserId(@PathVariable int userId){
        HashMap hashMap=new HashMap();
        try{
            ShoppingCart shoppingCart=shoppingCartService.getShoppingCartByUserId(userId);
            if(shoppingCart!=null){
                hashMap.put("shoppingCart",shoppingCart);
                return new ResponseEntity<>(hashMap,HttpStatus.OK);
            }else{
                shoppingCart=new ShoppingCart();
                shoppingCart.setUserId(userId);
                shoppingCart.setProductCount(0);
                shoppingCart.setTotalPrice(0);
                shoppingCart.setInsertBy("" + userId);
                shoppingCart.setInsertTime(new Date());
                int id=shoppingCartService.addShoppingCart(shoppingCart);
                if(id>=0){
                    hashMap.put("shoppingCart",shoppingCartService.getShoppingCartByUserId(userId));
                    return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
                }else{
                    hashMap.put("shoppingCart",null);
                    return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }catch (Exception e){
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes="application/json")
    public ResponseEntity<?> updateShoppingCartByUserId(@RequestBody ShoppingCart shoppingCart){
        HashMap hashMap=new HashMap();
        try{
            shoppingCart.setUpdateTime(new Date());
            if(shoppingCartService.updateShoppingCart(shoppingCart)){
                hashMap.put("message","update shopping cart ok.");
                return new ResponseEntity<>(hashMap,HttpStatus.OK);
            }else{
                hashMap.put("message","update shopping cart fail.");
                return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
