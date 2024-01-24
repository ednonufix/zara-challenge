package com.inditex.zarachallenge.product.domain.offers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductOffer(Long id, LocalDateTime validFrom, BigDecimal price) {
}