package com.xxbg.jbapi.db.dao;

import com.xxbg.jbapi.entity.ProductComment;

import java.util.List;

/**
 * Created by {liyan.code@gmail.com} on 12/13/15.
 */
public interface ProductCommentDAO {
    List<ProductComment> getCommentsByProductId(int productId);
    int insertProductComment(ProductComment productComment);
}
