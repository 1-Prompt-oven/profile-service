package com.promptoven.profileservice.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FollowStatDTO {

	private final Long following;
	private final Long follower;
}
