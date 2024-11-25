package com.promptoven.profileservice.application.service.dto;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Unwrapped.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileDTO {

	private final String memberUUID;
	private final String nickname;
	private final LocalDateTime createdAt;

	@Nullable
	private final String banner;
	@Nullable
	private final String profileImage;
	@Nullable
	private final String hashtag;
	@Nullable
	private final String bio;
	@Nullable
	private final String email;

}
