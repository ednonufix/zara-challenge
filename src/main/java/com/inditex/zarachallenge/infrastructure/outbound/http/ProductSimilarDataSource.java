package com.inditex.zarachallenge.infrastructure.outbound.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(name = "productSimilarDataSource", url = "http://localhost:3000/")
public interface ProductSimilarDataSource {

    @GetMapping("/product/{productId}/similarids")
    Iterable<Long> getSimilarProducts(@PathVariable String productId);

}
