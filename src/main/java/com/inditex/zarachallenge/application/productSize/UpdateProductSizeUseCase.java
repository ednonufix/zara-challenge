package com.inditex.zarachallenge.application.productSize;

import com.inditex.zarachallenge.domain.ProductSizeRepository;
import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProductSizeUseCase {

    private final ProductSizeRepository productSizeRepository;

    public void updateProductSize(ProductSizeUpdate productSizeUpdate) {
        productSizeRepository.updateProductSize(productSizeUpdate);
    }

}
