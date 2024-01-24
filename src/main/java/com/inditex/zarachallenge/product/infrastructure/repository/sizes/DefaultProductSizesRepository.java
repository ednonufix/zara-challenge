package com.inditex.zarachallenge.product.infrastructure.repository.sizes;

import com.inditex.zarachallenge.product.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.product.domain.sizes.ProductSizesRepository;
import com.inditex.zarachallenge.infrastructure.datasource.database.ProductSizesDatasource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DefaultProductSizesRepository implements ProductSizesRepository {

    private final ProductSizesDatasource productSizesDatasource;

    @Override
    public void updateProductSizes(ProductSizeUpdate productSizeUpdate) {
        productSizesDatasource.updateSizeAvailability(productSizeUpdate.sizeId(), productSizeUpdate.availability(), productSizeUpdate.lastUpdated());
    }

}
