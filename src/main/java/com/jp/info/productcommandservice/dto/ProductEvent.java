package com.jp.info.productcommandservice.dto;

import com.jp.info.productcommandservice.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEvent {
    private String eventType;
    private Product product;
}
