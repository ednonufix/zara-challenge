package com.inditex.zarachallenge.product.usesCases;

import com.inditex.zarachallenge.product.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.product.domain.sizes.ProductSizesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProductDetailsService {

    private final ProductSizesRepository productSizesRepository;

    public void updateProductSizes(ProductSizeUpdate productSizeUpdate) {
        productSizesRepository.updateProductSizes(productSizeUpdate);
    }

}
