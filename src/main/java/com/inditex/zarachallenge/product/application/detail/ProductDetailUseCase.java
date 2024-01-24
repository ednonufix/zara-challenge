package com.inditex.zarachallenge.product.application.detail;


import com.inditex.zarachallenge.controller.model.ProductDetailResponse;
import com.inditex.zarachallenge.product.domain.ProductDetailRepository;
import com.inditex.zarachallenge.product.domain.details.ProductDetail;
import com.inditex.zarachallenge.product.domain.offers.ProductOffer;
import com.inditex.zarachallenge.product.domain.sizes.ProductSize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductDetailUseCase {

    private final LocalDateTime currentDate;
    private final ProductDetailRepository productDetailRepository;

    public ProductDetailUseCase(@Value("${date}") String date, ProductDetailRepository productDetailRepository) {
        this.currentDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        this.productDetailRepository = productDetailRepository;
    }

    public Set<ProductDetailResponse> getSimilarProducts(String productId) {
        List<ProductDetail> similarProducts = productDetailRepository.getSimilarProducts(productId);
        Comparator<ProductDetailResponse> comparator = Comparator.comparing(ProductDetailResponse::availability).thenComparing(ProductDetailResponse::name);

        return similarProducts.stream()
            .map(this::getProductDetailResponse)
            .filter(java.util.Objects::nonNull)
            .sorted(comparator)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private ProductDetailResponse getProductDetailResponse(ProductDetail product) {
        ProductOffer latestOffer = getLatestValidOffer(product.offers());

        if (latestOffer == null) {
            return null;
        }

        boolean availability = getAvailabilityOfProduct(product.id(), product.sizes());
        return new ProductDetailResponse(product.id().toString(), product.name(), latestOffer.price(), availability);
    }

    private ProductOffer getLatestValidOffer(List<ProductOffer> offers) {
        return offers.stream()
            .filter(offer -> !offer.validFrom().isAfter(currentDate))
            .max(Comparator.comparing(ProductOffer::validFrom))
            .orElse(null);
    }

    private boolean getAvailabilityOfProduct(long idProduct, List<ProductSize> sizes) {
        return sizes.stream()
            .filter(id -> id.productId().equals(idProduct))
            .map(ProductSize::availability)
            .findFirst()
            .orElse(false);
    }

}
