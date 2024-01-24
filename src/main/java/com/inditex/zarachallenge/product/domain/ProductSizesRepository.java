package com.inditex.zarachallenge.product.domain;

import com.inditex.zarachallenge.product.domain.sizes.ProductSizeUpdate;

public interface ProductSizesRepository {


    void updateProductSizes(ProductSizeUpdate productSizeUpdate);
}
