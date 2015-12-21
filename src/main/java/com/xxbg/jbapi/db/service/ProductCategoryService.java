package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ProductCategoryDAO;
import com.xxbg.jbapi.db.dao.impl.ProductCategoryDAOImpl;
import com.xxbg.jbapi.entity.ProductCategory;

/**
 * Created by yanli6 on 12/8/15.
 */
public class ProductCategoryService {
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
