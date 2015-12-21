package com.xxbg.jbapi.entity;

/**
 * Created by yanli6 on 12/2/15.
 */
public class PaymentType {
    private int id;
    private String enName;
    private String cnName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
