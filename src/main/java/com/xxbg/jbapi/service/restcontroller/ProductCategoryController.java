package com.xxbg.jbapi.service.restcontroller;

import com.xxbg.jbapi.db.service.ProductCategoryService;
import com.xxbg.jbapi.entity.ProductCategory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yanli6 on 12/8/15.
 */
@RestController
@RequestMapping("/productCategories")
public class ProductCategoryController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProductCategory getProductCategoryById(@PathVariable int id){
        ProductCategory productCategory=new ProductCategoryService().getProductCategoryById(id);
        if(productCategory==null){
            return null;
        }else{
            return productCategory;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,consumes="application/json")
    public int addProduct(@RequestBody ProductCategory productCategory){

        return new ProductCategoryService().addProductCategory(productCategory);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean deleteProductCategoryById(@PathVariable int id){
        return new ProductCategoryService().deleteProductCategoryById(id);
    }
}
