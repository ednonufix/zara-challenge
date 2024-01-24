package com.inditex.zarachallenge.infrastructure.datasource.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "SIZE")
@Entity
public class ProductSizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SIZE_ID", nullable = false)
    private Long id;

    @Column(name = "SIZE", nullable = false)
    private String size;

    @Column(name = "AVAILABILITY", nullable = false)
    private Boolean availability;

    @Column(name = "LAST_UPDATED", nullable = false)
    private LocalDateTime lastUpdated;


    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductDetailEntity productDetailEntity;

}
