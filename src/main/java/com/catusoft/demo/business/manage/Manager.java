package com.catusoft.demo.business.manage;

import com.catusoft.demo.infrastructure.client.product.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;


@Configuration
public class Manager {
    private static final Logger log = LoggerFactory.getLogger(Manager.class);
    private final RestTemplate restTemplate;
    private final String serviceAUrl;

    Manager(RestTemplate restTemplate, @Value("${service.petshopclient.url}/product") String petShopClientUrl) {
        this.restTemplate = restTemplate;
        this.serviceAUrl = petShopClientUrl;
    }

    @Scheduled( fixedRate = 60 * 60 * 1000)
    public void fetchProducts() {
        log.info("[CRON JOB] Fetching products from PetShop client A");
        List<ProductDTO> products = Arrays.asList(restTemplate.getForObject(serviceAUrl, ProductDTO[].class));
        products.forEach(product -> System.out.println(product.getProductName()));
    }
}
