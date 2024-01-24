package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.controller.model.ProductDetailResponse;
import com.inditex.zarachallenge.product.usesCases.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor
@RestController
public class SimilarController {

    private final ProductDetailService productDetailService;

    // TODO: Insert code in this controller
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<Set<ProductDetailResponse>> getSimilarProducts(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productDetailService.getSimilarProducts(productId));
    }
}
