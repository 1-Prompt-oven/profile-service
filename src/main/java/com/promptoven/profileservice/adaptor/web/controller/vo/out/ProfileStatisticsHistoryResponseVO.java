package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfileStatisticsHistoryResponseVO {

	private final LocalDate targetDate;
	private final String memberUUID;
	private final Long viewer;
	private final Long sales;
	private final Long rank;
	private final Double rating;
	private final Long follower;
}
