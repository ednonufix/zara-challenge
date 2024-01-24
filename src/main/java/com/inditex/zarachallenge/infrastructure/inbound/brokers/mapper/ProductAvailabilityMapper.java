package com.inditex.zarachallenge.infrastructure.inbound.brokers.mapper;

import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.infrastructure.inbound.brokers.model.ProductAvailabilityEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductAvailabilityMapper {

    @Mapping(target = "lastUpdated", source = "update")
    ProductSizeUpdate productSizeUpdate(ProductAvailabilityEvent event);

}
