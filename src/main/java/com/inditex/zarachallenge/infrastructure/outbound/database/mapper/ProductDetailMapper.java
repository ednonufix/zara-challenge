package com.inditex.zarachallenge.infrastructure.outbound.database.mapper;

import com.inditex.zarachallenge.domain.details.ProductDetail;
import com.inditex.zarachallenge.domain.offers.ProductOffer;
import com.inditex.zarachallenge.domain.sizes.ProductSize;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductDetailEntity;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductOfferEntity;
import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductSizeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {

    @Mapping(target = "offers", source = "productOfferEntities")
    @Mapping(target = "sizes", source = "productSizeEntities")
    ProductDetail detail(ProductDetailEntity productDetailEntity);

    ProductOffer offer(ProductOfferEntity productOfferEntity);

    @Mapping(target = "productId", source = "productDetailEntity.id")
    ProductSize size(ProductSizeEntity productSizeEntity);

}
