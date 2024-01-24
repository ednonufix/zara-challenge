package com.inditex.zarachallenge.infrastructure.datasource.database;

import com.inditex.zarachallenge.infrastructure.datasource.database.entities.ProductSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ProductSizesDatasource extends JpaRepository<ProductSizeEntity, Long> {

    @Transactional
    @Modifying
    @Query("update ProductSizeEntity p set p.availability = :availability, p.lastUpdated = :lastUpdated where p.id = :id")
    void updateSizeAvailability(@Param("id") Long id, @Param("availability") Boolean availability, @Param("lastUpdated") LocalDateTime lastUpdated);
}
