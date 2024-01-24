package com.inditex.zarachallenge.infrastructure.outbound.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "OFFER")
@Entity
public class ProductOfferEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "VALID_FROM", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;


    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, unique = true)
    private ProductDetailEntity productDetailEntity;

}
