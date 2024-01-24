package com.inditex.zarachallenge.domain.details;

import java.math.BigDecimal;

public record ProductDetailResponse(String id, String name, BigDecimal price, boolean availability) {
}
