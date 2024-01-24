package com.inditex.zarachallenge.infrastructure.outbound.http;

import com.inditex.zarachallenge.AbstractIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ProductSimilarApiClientTest extends AbstractIntegrationTest {

    @Autowired
    private ProductSimilarApiClient productSimilarApiClient;

    @Test
    void getSimilarProducts() {

        Iterable<Long> result = productSimilarApiClient.getSimilarProducts("1");

        Assertions.assertThat(result).isNotNull()
            .hasSize(3)
            .containsExactly(2L, 3L, 4L);
    }

}