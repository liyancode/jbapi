package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.UserService;
import com.xxbg.jbapi.entity.User;
import com.xxbg.jbapi.service.common.CommonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by yanli6 on 12/16/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    static Logger logger= LogManager.getLogger(UserController.class);
    private UserService userService;

    public UserController(){
        userService=new UserService();
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes="application/json")
    public ResponseEntity<?> userRegister(@RequestBody User user){
        HashMap hashMap=new HashMap();
        try{
            if((userService.getUserByUsername(user.getUserName())!=null)||(userService.getUserByEmail(user.getEmail())!=null)){
                //already exists
                hashMap.put("message","userName="+user.getUserName()+" or email="+user.getEmail()+" already registered!");
                return new ResponseEntity<>(hashMap, HttpStatus.CONFLICT);
            }else{
                hashMap.put("id",userService.addUser(user));
                return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
            }
        }catch(Exception e){
            logger.error("/users/register"+" -- "+e.getStackTrace());
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getUser(
            @RequestParam(value = "user_name",required = false) String userName,
            @RequestParam(value = "id",required = false) Integer id){
        HashMap hashMap=new HashMap();
        try{
            if(userName==null&&id==null){
                hashMap.put("message","No user_name or id specified. /?user_name={} or /?id={}");
                return new ResponseEntity<>(hashMap,HttpStatus.METHOD_NOT_ALLOWED);
            }else{
                if(userName!=null){
                    User user=userService.getUserByUsername(userName);
                    if(user!=null){
                        hashMap.put("user",user);
                        return new ResponseEntity<>(hashMap,HttpStatus.OK);
                    }else{
                        if(id!=null){
                            user=userService.getUserById(id.intValue());
                            if(user!=null){
                                hashMap.put("user",user);
                                return new ResponseEntity<>(hashMap,HttpStatus.OK);
                            }else{
                                hashMap.put("errorMessage","User not found by userName="+userName+" or id="+id.intValue());
                                return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
                            }
                        }else{
                            hashMap.put("errorMessage","User not found by userName="+userName);
                            return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
                        }
                    }
                }else{
                    User user=userService.getUserById(id.intValue());
                    if(user!=null){
                        hashMap.put("user",user);
                        return new ResponseEntity<>(hashMap,HttpStatus.OK);
                    }else{
                        hashMap.put("errorMessage","User not found by id="+id.intValue());
                        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
                    }
                }
            }

        }catch (Exception e){
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public ResponseEntity<?> authUser(
            @RequestParam(value = "user_name",required = true) String userName,
            @RequestParam(value = "password",required = true) String password){
        HashMap hashMap=new HashMap();
        try{
            User user=userService.getUserByUsername(userName);
            if(user==null){
                hashMap.put("errorMessage","User not found by userName="+userName);
                return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
            }else{
                boolean authResult= CommonHelper.verifyPassword(user.getPassword(),password);
                System.out.println(authResult);
                if(authResult){
                    hashMap.put("message","Authorized");
                    return new ResponseEntity<>(hashMap,HttpStatus.OK);
                }else{
                    hashMap.put("message","UNAuthorized");
                    return new ResponseEntity<>(hashMap,HttpStatus.UNAUTHORIZED);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            hashMap.put("errorMessage",e.getMessage());
            return new ResponseEntity<>(hashMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
