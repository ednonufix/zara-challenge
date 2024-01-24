package com.inditex.zarachallenge.domain;

import com.inditex.zarachallenge.domain.details.ProductDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository {

    List<ProductDetail> getSimilarProducts(String productId);

}
