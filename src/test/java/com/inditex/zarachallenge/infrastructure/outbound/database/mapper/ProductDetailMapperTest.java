package com.inditex.zarachallenge.infrastructure.outbound.database.mapper;

import com.inditex.zarachallenge.domain.details.ProductDetail;
import com.inditex.zarachallenge.domain.offers.ProductOffer;
import com.inditex.zarachallenge.domain.sizes.ProductSize;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductDetailEntity;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductOfferEntity;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductSizeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductDetailMapperTest {

    @InjectMocks
    private ProductDetailMapper productDetailMapper = new ProductDetailMapperImpl();

    @Test
    void detail() {

        ProductDetailEntity productDetailEntity = generateDatabaseData();

        ProductDetail detail = productDetailMapper.detail(productDetailEntity);

        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        ProductSize productSizeExpected = new ProductSize(1L, "S", true, 1L, dateTime);
        ProductOffer productOfferExpected = new ProductOffer(1L, dateTime, BigDecimal.ONE);
        ProductDetail productDetailExpected = new ProductDetail(1L, "name", List.of(productOfferExpected), List.of(productSizeExpected));

        Assertions.assertThat(detail)
            .isNotNull()
            .usingRecursiveComparison()
            .isEqualTo(productDetailExpected);
    }

    private ProductDetailEntity generateDatabaseData() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        ProductDetailEntity productDetailEntity = new ProductDetailEntity();
        productDetailEntity.setId(1L);
        productDetailEntity.setName("name");

        ProductSizeEntity productSizeEntity = new ProductSizeEntity();
        productSizeEntity.setId(1L);
        productSizeEntity.setSize("S");
        productSizeEntity.setAvailability(true);
        productSizeEntity.setLastUpdated(dateTime);
        productSizeEntity.setProductDetailEntity(productDetailEntity);

        ProductOfferEntity productOfferEntity = new ProductOfferEntity();
        productOfferEntity.setId(1L);
        productOfferEntity.setPrice(BigDecimal.ONE);
        productOfferEntity.setValidFrom(dateTime);
        productOfferEntity.setProductDetailEntity(productDetailEntity);

        productDetailEntity.setProductOfferEntities(List.of(productOfferEntity));
        productDetailEntity.setProductSizeEntities(List.of(productSizeEntity));

        return productDetailEntity;
    }

}