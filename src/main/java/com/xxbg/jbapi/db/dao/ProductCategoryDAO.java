package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ProductCategory;

/**
 * Created by {liyan.code@gmail.com} on 12/8/15.
 */
public interface ProductCategoryDAO {
    int insertProductCategory(ProductCategory productCategory);
    boolean deleteProductCategoryById(int id);
    boolean updateProductCategory(ProductCategory productCategory);
    ProductCategory getProductCategoryById(int id);
}
