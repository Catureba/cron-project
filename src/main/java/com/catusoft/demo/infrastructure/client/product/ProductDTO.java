package com.catusoft.demo.infrastructure.client.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productName;

    private String productDescription;

    private Float productPrice;

    private Integer stock;
}
