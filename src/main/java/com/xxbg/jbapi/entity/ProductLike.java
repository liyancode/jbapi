package com.xxbg.jbapi.entity;

import java.util.Date;

/**
 * Created by yanli6 on 12/2/15.
 */
public class ProductLike {
    private int id;
    private int productId;
    private int userId;
    private java.util.Date insertTime;
    private int status;
    public ProductLike(){}
    public ProductLike(int productId,int userId,java.util.Date insertTime,int status){
        this.productId=productId;
        this.userId=userId;
        this.insertTime=insertTime;
        this.status=status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
