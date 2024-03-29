package com.inditex.zarachallenge.domain.sizes;

import java.time.LocalDateTime;

public record ProductSize(Long id, String size, Boolean availability, Long productId, LocalDateTime lastUpdated) {
}