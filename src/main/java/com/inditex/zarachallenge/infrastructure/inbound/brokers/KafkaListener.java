package com.inditex.zarachallenge.infrastructure.inbound.brokers;

import com.inditex.zarachallenge.application.productSize.UpdateProductSizeUseCase;
import com.inditex.zarachallenge.domain.sizes.ProductSizeUpdate;
import com.inditex.zarachallenge.infrastructure.inbound.brokers.mapper.ProductAvailabilityMapper;
import com.inditex.zarachallenge.infrastructure.inbound.brokers.model.ProductAvailabilityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@RequiredArgsConstructor
@Component
public class KafkaListener {

	private final ProductAvailabilityMapper productAvailabilityMapper;
	private final UpdateProductSizeUseCase updateProductSizeUseCase;

	@Bean
	public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
		return message -> {
			ProductAvailabilityEvent event = message.getPayload();
			ProductSizeUpdate productSizeUpdate = productAvailabilityMapper.productSizeUpdate(event);
			updateProductSizeUseCase.updateProductSize(productSizeUpdate);
		};
	}

}
