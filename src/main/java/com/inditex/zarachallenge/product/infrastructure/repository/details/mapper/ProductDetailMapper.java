package com.inditex.zarachallenge.product.infrastructure.repository.details.mapper;

import com.inditex.zarachallenge.infrastructure.datasource.database.entities.ProductDetailEntity;
import com.inditex.zarachallenge.infrastructure.datasource.database.entities.ProductOfferEntity;
import com.inditex.zarachallenge.infrastructure.datasource.database.entities.ProductSizeEntity;
import com.inditex.zarachallenge.product.domain.details.ProductDetail;
import com.inditex.zarachallenge.product.domain.offers.ProductOffer;
import com.inditex.zarachallenge.product.domain.sizes.ProductSize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {

    @Mapping(target = "offers", source = "productOfferEntities")
    @Mapping(target = "sizes", source = "productSizeEntities")
    ProductDetail map(ProductDetailEntity productDetailEntity);

    ProductOffer offer(ProductOfferEntity productOfferEntity);

    @Mapping(target = "productId", source = "productDetailEntity.id")
    ProductSize size(ProductSizeEntity productSizeEntity);

}
