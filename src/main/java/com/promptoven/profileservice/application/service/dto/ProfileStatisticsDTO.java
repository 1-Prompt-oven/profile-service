package com.promptoven.profileservice.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ProfileStatisticsDTO {

	private final String memberUUID;

	private final Long viewer;

	private final Long sales;

	private final Long rank;

	private final Double rating;

}
