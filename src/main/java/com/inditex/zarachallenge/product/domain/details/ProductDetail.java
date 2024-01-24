package com.inditex.zarachallenge.product.domain.details;

import com.inditex.zarachallenge.product.domain.offers.ProductOffer;
import com.inditex.zarachallenge.product.domain.sizes.ProductSize;

import java.util.List;


public record ProductDetail(Long id, String name, List<ProductOffer> offers, List<ProductSize> sizes) {
}