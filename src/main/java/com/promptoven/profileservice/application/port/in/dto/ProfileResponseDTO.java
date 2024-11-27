package com.promptoven.profileservice.application.port.in.dto;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Unwrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfileResponseDTO {

	private final String memberUUID;
	private final String nickname;
	private final LocalDateTime createdAt;

	@Unwrapped.Nullable
	private final String banner;
	@Unwrapped.Nullable
	private final String profileImage;
	@Unwrapped.Nullable
	private final String hashtag;
	@Unwrapped.Nullable
	private final String bio;
	@Unwrapped.Nullable
	private final String email;

	private final boolean isWithdrew;
	private final boolean isBanned;
	private final boolean isCreator;

	private final Long viewer;
	private final Long sales;
	private final Long following;
	private final Long follower;

}
