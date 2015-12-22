package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ProductLike;

import java.util.HashMap;
import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/13/15.
 */
public interface ProductLikeDAO {
    List<ProductLike> getLikesByProductId(int productId);
    int insertProductLike(ProductLike productLike);
    int countProductLikeByProductidAndUserid(HashMap hashMap);
    boolean updateStatus(HashMap hashMap);
}
