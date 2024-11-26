package com.promptoven.profileservice.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UnfollowRequestDTO {

	private final String FollowerID;
	private final String CreatorNickname;
}
