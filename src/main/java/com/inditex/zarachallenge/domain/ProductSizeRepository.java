package com.inditex.zarachallenge.domain;

import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;

public interface ProductSizeRepository {

    void updateProductSize(ProductSizeUpdate productSizeUpdate);
}
