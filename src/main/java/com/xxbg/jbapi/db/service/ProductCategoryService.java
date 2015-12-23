package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ProductCategoryDAO;
import com.xxbg.jbapi.db.dao.impl.ProductCategoryDAOImpl;
import com.xxbg.jbapi.entity.ProductCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by {liyan.code@gmail.com} on 12/8/15.
 */
public class ProductCategoryService {
    static Logger logger= LogManager.getLogger(ProductCategoryService.class);

    private ProductCategoryDAO productCategoryDAO;

    public ProductCategoryService(){
        productCategoryDAO=new ProductCategoryDAOImpl();
    }

    public int addProductCategory(ProductCategory productCategory){
        return productCategoryDAO.insertProductCategory(productCategory);
    }

    public boolean deleteProductCategoryById(int id){
        return productCategoryDAO.deleteProductCategoryById(id);
    }

    public boolean updateProductCategory(ProductCategory productCategory){
        return productCategoryDAO.updateProductCategory(productCategory);
    }

    public ProductCategory getProductCategoryById(int id){
        return productCategoryDAO.getProductCategoryById(id);
    }
}
