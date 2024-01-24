package com.inditex.zarachallenge.infrastructure.inbound.brokers.mapper;

import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.infrastructure.inbound.brokers.model.ProductAvailabilityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProductAvailabilityMapperTest {

    @InjectMocks
    private ProductAvailabilityMapper productAvailabilityMapper = new ProductAvailabilityMapperImpl();

    @Test
    void productSizeUpdate() {

        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        ProductAvailabilityEvent event = ProductAvailabilityEvent.builder()
            .sizeId(1L)
            .availability(true)
            .update(Timestamp.valueOf(dateTime))
            .build();

        ProductSizeUpdate result = productAvailabilityMapper.productSizeUpdate(event);

        ProductSizeUpdate expected = new ProductSizeUpdate(1L, true, LocalDateTime.of(2024, 1, 1, 0, 0, 0));

        assertEquals(expected, result);

    }
}