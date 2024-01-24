package com.inditex.zarachallenge.infrastructure.outbound.database;

import com.inditex.zarachallenge.infrastructure.outbound.database.entities.ProductSizeEntity;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@DataJpaTest
class ProductSizeDatabaseRepositoryTest {

    @Autowired
    private ProductSizeDatabaseRepository productSizeDatabaseRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test
    void updateSizeAvailability() {

        ProductSizeEntity beforeUpdate = productSizeDatabaseRepository.findById(1L).orElseThrow();

        ProductSizeEntity beforeUpdateExpected = new ProductSizeEntity();
        beforeUpdateExpected.setId(1L);
        beforeUpdateExpected.setSize("S");
        beforeUpdateExpected.setAvailability(true);
        beforeUpdateExpected.setLastUpdated(LocalDateTime.parse("2021-12-12T01:37:30.903"));

        Assertions.assertThat(beforeUpdate)
            .isNotNull()
            .usingRecursiveComparison()
            .ignoringFields("productDetailEntity")
            .isEqualTo(beforeUpdateExpected);

        productSizeDatabaseRepository.updateSizeAvailability(1L, false, LocalDateTime.of(2024, 1, 1, 0, 0, 0));
        ProductSizeEntity afterUpdate = productSizeDatabaseRepository.findById(1L).orElseThrow();
        entityManager.refresh(afterUpdate);

        ProductSizeEntity afterUpdateExpected = new ProductSizeEntity();
        afterUpdateExpected.setId(1L);
        afterUpdateExpected.setSize("S");
        afterUpdateExpected.setAvailability(false);
        afterUpdateExpected.setLastUpdated(LocalDateTime.of(2024, 1, 1, 0, 0, 0));

        Assertions.assertThat(afterUpdate)
            .isNotNull()
            .usingRecursiveComparison()
            .ignoringFields("productDetailEntity")
            .isEqualTo(afterUpdateExpected);
    }
}