package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.Product;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yanli6 on 11/30/15.
 */
public interface ProductDAO {
    /**
     * @return generated primary key (id)
     * */
    int insertProduct(Product product);
    boolean deleteProductById(int id);
    boolean updateProduct(Product product);
    Product getProductById(int id);

    /**
     * default get
     * */
    List<Product> getProducts(HashMap hashMap);
    List<Product> getProductsByCategoryId(HashMap hashMap);
    List<Product> getProductsByCategoryIdAndStatus(HashMap hashMap);
    List<Product> getProductsByCategoryIdAndSort(HashMap hashMap);
    List<Product> getProductsByCategoryIdAndStatusAndSort(HashMap hashMap);
    List<Product> getProductsByStatus(HashMap hashMap);
    List<Product> getProductsByStatusAndSort(HashMap hashMap);
    List<Product> getProductsBySort(HashMap hashMap);

    /**
     * update *_count
     * */
    boolean commentCountMinusOne(int id);
    boolean commentCountPlusOne(int id);
    boolean likeCountMinusOne(int id);
    boolean likeCountPlusOne(int id);
}
