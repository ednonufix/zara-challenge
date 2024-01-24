package com.inditex.zarachallenge.infrastructure;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.function.Consumer;

import com.inditex.zarachallenge.product.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.product.usesCases.UpdateProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;

@RequiredArgsConstructor
@Component
public class KafkaListener {

	private final UpdateProductDetailsService updateProductDetailsService;

	@Bean
	public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
		return message -> {
			ProductAvailabilityEvent event = message.getPayload();
			Instant instant = event.getUpdate().toInstant();
			LocalDateTime lastUpdate = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
			ProductSizeUpdate productSizeUpdate = new ProductSizeUpdate(event.getSizeId(), event.isAvailability(), lastUpdate);
			updateProductDetailsService.updateProductSizes(productSizeUpdate);
		};
	}

}
