package com.inditex.zarachallenge.product.infrastructure.repository.details;

import com.inditex.zarachallenge.infrastructure.datasource.database.ProductDetailDatasource;
import com.inditex.zarachallenge.infrastructure.datasource.database.entities.ProductDetailEntity;
import com.inditex.zarachallenge.infrastructure.datasource.http.ProductSimilarDataSource;
import com.inditex.zarachallenge.product.domain.ProductDetailRepository;
import com.inditex.zarachallenge.product.domain.details.ProductDetail;
import com.inditex.zarachallenge.product.infrastructure.repository.details.mapper.ProductDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DefaultProductDetailRepository implements ProductDetailRepository {

    private final ProductDetailDatasource productDetailDatasource;
    private final ProductSimilarDataSource productSimilarDataSource;
    private final ProductDetailMapper productDetailMapper;

    @Override
    public List<ProductDetail> getSimilarProducts(String productId) {
        Iterable<Long> similarProducts = productSimilarDataSource.getSimilarProducts(productId);
        List<ProductDetailEntity> productDetailEntityList = productDetailDatasource.findAllById(similarProducts);
        return productDetailEntityList.stream().map(productDetailMapper::map).toList();
    }
}
