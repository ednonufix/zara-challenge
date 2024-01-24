package com.inditex.zarachallenge.infrastructure.outbound.database;

import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailDatabaseRepository extends JpaRepository<ProductDetailEntity, Long> {

}
