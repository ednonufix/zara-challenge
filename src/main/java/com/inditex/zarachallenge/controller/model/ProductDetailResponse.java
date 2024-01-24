package com.inditex.zarachallenge.controller.model;

import java.math.BigDecimal;

public record ProductDetailResponse(String id, String name, BigDecimal price, boolean availability) {
}
