package com.jp.info.productcommandservice.repository;

import com.jp.info.productcommandservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
