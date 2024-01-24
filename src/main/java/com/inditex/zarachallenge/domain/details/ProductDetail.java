package com.inditex.zarachallenge.domain.details;

import com.inditex.zarachallenge.domain.offers.ProductOffer;
import com.inditex.zarachallenge.domain.sizes.ProductSize;

import java.util.List;


public record ProductDetail(Long id, String name, List<ProductOffer> offers, List<ProductSize> sizes) {
}