package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.domain.ProductSizeRepository;
import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.infrastructure.outbound.database.ProductSizeDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DefaultProductSizesRepository implements ProductSizeRepository {

    private final ProductSizeDatabaseRepository productSizeDatabaseRepository;

    @Override
    public void updateProductSize(ProductSizeUpdate productSizeUpdate) {
        productSizeDatabaseRepository.updateSizeAvailability(productSizeUpdate.sizeId(), productSizeUpdate.availability(), productSizeUpdate.lastUpdated());
    }

}
