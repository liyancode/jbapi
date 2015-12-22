package com.xxbg.jbapi.service.common;


/**
 * Created by {liyan.code@gmail.com} on 12/16/15.
 */
public class CommonHelper {

    public static boolean verifyPassword(String metaPassword,String toVerifyPassword){
        try{
            return metaPassword.equals(toVerifyPassword);
        }catch(Exception e){
            return false;
        }
    }
}
