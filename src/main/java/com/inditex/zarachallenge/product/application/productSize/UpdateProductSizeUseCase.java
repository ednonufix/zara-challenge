package com.inditex.zarachallenge.product.application.productSize;

import com.inditex.zarachallenge.product.domain.ProductSizesRepository;
import com.inditex.zarachallenge.product.domain.sizes.ProductSizeUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProductSizeUseCase {

    private final ProductSizesRepository productSizesRepository;

    public void updateProductSizes(ProductSizeUpdate productSizeUpdate) {
        productSizesRepository.updateProductSizes(productSizeUpdate);
    }

}
