package com.inditex.zarachallenge.product.domain.details;

import com.inditex.zarachallenge.product.domain.details.ProductDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository {

    List<ProductDetail> getSimilarProducts(String productId);

}
