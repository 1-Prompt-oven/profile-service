package com.promptoven.profileservice.application.service.dto;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FollowingDTO {

	private final String follower;
	private final String followee;
	private final LocalDateTime FollowDate;
	@Nullable
	private final LocalDateTime UnfollowDate;
}
