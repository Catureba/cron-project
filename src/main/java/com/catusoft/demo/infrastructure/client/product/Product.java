package com.catusoft.demo.infrastructure.client.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;

    private String productName;

    private String productDescription;

    private Float productPrice;

    private Integer stock;
}
