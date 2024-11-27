package com.promptoven.profileservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfileStatisticsModelDTO {

	private final String memberUUID;

	private final Long viewer;

	private final Long sales;

	private final Long rank;

	private final Double rating;

}
