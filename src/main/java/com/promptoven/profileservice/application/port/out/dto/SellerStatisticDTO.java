package com.promptoven.profileservice.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class SellerStatisticDTO {

	private final String memberUUID;
	private final Long sales;
	private final Long rank;
	private final Double reviewAvg;
}
