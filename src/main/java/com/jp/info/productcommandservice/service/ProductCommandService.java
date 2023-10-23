package com.jp.info.productcommandservice.service;

import com.jp.info.productcommandservice.dto.ProductEvent;
import com.jp.info.productcommandservice.entity.Product;
import com.jp.info.productcommandservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public Product createProduct(ProductEvent productEvent){
        Product product = repository.save(productEvent.getProduct());
        ProductEvent event=new ProductEvent("CreateProductEvent",product);

        kafkaTemplate.send("product-event-topic",event);
        return product;
    }

    public Product updateProduct(Long id,ProductEvent productEvent){
        Product existingProduct = repository.findById(id).get();
        Product newProduct=productEvent.getProduct();
        existingProduct=Product.builder()
                .description(newProduct.getDescription())
                .price(newProduct.getPrice())
                .name(newProduct.getName())
                .build();
        Product product = repository.save(existingProduct);
        ProductEvent event=new ProductEvent("UpdateProductEvent",existingProduct);
        kafkaTemplate.send("product-event-topic",event);
        return existingProduct;
    }

}
