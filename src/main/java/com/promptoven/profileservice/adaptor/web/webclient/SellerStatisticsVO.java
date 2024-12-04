package com.promptoven.profileservice.adaptor.web.webclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SellerStatisticsVO {

	private String memberUuid;
	private Long ranking;
	private Long sellsCount;
}