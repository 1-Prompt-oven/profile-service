package com.promptoven.profileservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FollowingModelDTO {

	private final String FollowerID;
	private final String FolloweeID;

}
