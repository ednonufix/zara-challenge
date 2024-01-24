package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.domain.details.ProductDetail;
import com.inditex.zarachallenge.infrastructure.outbound.database.ProductDetailDatabaseRepository;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductDetailEntity;
import com.inditex.zarachallenge.infrastructure.outbound.database.mapper.ProductDetailMapper;
import com.inditex.zarachallenge.infrastructure.outbound.http.ProductSimilarApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DefaultProductDetailRepository implements com.inditex.zarachallenge.domain.ProductDetailRepository {

    private final ProductDetailDatabaseRepository productDetailDatabaseRepository;
    private final ProductDetailMapper productDetailMapper;
    private final ProductSimilarApiClient productSimilarApiClient;

    @Override
    public List<ProductDetail> getSimilarProducts(String productId) {
        Iterable<Long> similarProducts = productSimilarApiClient.getSimilarProducts(productId);
        List<ProductDetailEntity> productDetailEntityList = productDetailDatabaseRepository.findAllById(similarProducts);
        return productDetailEntityList.stream().map(productDetailMapper::detail).toList();
    }
}
