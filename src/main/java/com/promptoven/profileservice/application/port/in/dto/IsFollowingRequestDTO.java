package com.promptoven.profileservice.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class IsFollowingRequestDTO {

	private final String follower;
	private final String followee;
}
