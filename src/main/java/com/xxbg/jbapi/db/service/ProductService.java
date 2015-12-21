package com.xxbg.jbapi.db.service;

import com.xxbg.jbapi.db.dao.ProductDAO;
import com.xxbg.jbapi.db.dao.impl.ProductDAOImpl;
import com.xxbg.jbapi.entity.Product;
import com.xxbg.jbapi.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yanli6 on 11/30/15.
 */
public class ProductService {

    static Logger logger= LogManager.getLogger(ProductService.class);

    private ProductDAO productDAO;

    public ProductService(){
        productDAO=new ProductDAOImpl();
    }
    public int addProduct(Product product){
        return productDAO.insertProduct(product);
    }

    public boolean deleteProductById(int id){
        return productDAO.deleteProductById(id);
    }

    public boolean updateProduct(Product product){
        return productDAO.updateProduct(product);
    }

    public Product getProductById(int id){
        System.out.println("ProductService line29");
        return productDAO.getProductById(id);
    }

//    public List<Product> getAllProducts(){
//        return productDAO.getAllProducts();
//    }
//
//    public List<Product> getProductsByCategoryIdAndSort(int categoryId,String sort){
//        HashMap hashMap=new HashMap();
//        hashMap.put("categoryId",categoryId);
//        hashMap.put("sort",sort);
//        return productDAO.getProductsByCategoryIdAndSort(hashMap);
//    }

    public List<Product> getProducts(Integer categoryId,Integer status,String sort,Integer page){
        logger.info("getProducts("+categoryId+","+status+","+sort+","+page+")");
        try{
            HashMap hashMap=new HashMap();
            hashMap.put("offset",page.intValue()*Util.LIMIT_COUNT_PER_PAGE);
            hashMap.put("limit", Util.LIMIT_COUNT_PER_PAGE);
            if(categoryId!=null){
                hashMap.put("categoryId",categoryId.intValue());
                if(status!=null){
                    hashMap.put("status",status.intValue());
                    if(sort!=null){
                        hashMap.put("sort",sort);
                        return productDAO.getProductsByCategoryIdAndStatusAndSort(hashMap);
                    }else{
                        return productDAO.getProductsByCategoryIdAndStatus(hashMap);
                    }
                }else{
                    if(sort!=null){
                        hashMap.put("sort",sort);
                        return productDAO.getProductsByCategoryIdAndSort(hashMap);
                    }else{
                        return productDAO.getProductsByCategoryId(hashMap);
                    }
                }
            }else{
                if(status!=null){
                    hashMap.put("status",status.intValue());
                    if(sort!=null){
                        hashMap.put("sort",sort);
                        return productDAO.getProductsByStatusAndSort(hashMap);
                    }else{
                        return productDAO.getProductsByStatus(hashMap);
                    }
                }else{
                    if(sort!=null){
                        hashMap.put("sort",sort);
                        return productDAO.getProductsBySort(hashMap);
                    }else{
                        return productDAO.getProducts(hashMap);
                    }
                }
            }
        }catch(Exception e){
            return null;
        }
    }
}
