package com.jp.info.productcommandservice.controller;

import com.jp.info.productcommandservice.dto.ProductEvent;
import com.jp.info.productcommandservice.entity.Product;
import com.jp.info.productcommandservice.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    @Autowired
    private ProductCommandService service;
    @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent){
        return service.createProduct(productEvent);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,@RequestBody ProductEvent productEvent){
        return service.updateProduct(productId,productEvent);
    }
}
