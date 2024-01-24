package com.inditex.zarachallenge.infrastructure.inbound.brokers.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
public class ProductAvailabilityEvent implements Serializable {

	private static final long serialVersionUID = -6915528229848073283L;

	private Long sizeId;

	private boolean availability;

	private Timestamp update;

}
