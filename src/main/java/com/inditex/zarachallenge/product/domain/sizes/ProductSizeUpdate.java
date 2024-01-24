package com.inditex.zarachallenge.product.domain.sizes;

import java.time.LocalDateTime;

public record ProductSizeUpdate(Long sizeId, Boolean availability, LocalDateTime lastUpdated) {
}
