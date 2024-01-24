package com.inditex.zarachallenge.infrastructure.datasource.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "PRODUCT")
@Entity
public class ProductDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "productDetailEntity", orphanRemoval = true)
    private List<ProductOfferEntity> productOfferEntities = new ArrayList<>();

    @OneToMany(mappedBy = "productDetailEntity", orphanRemoval = true)
    private List<ProductSizeEntity> productSizeEntities = new ArrayList<>();

}
