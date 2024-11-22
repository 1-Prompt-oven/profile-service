package com.promptoven.profileservice.domain.dto;

import org.springframework.data.mongodb.core.mapping.Unwrapped.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileModelDTO {
	private final String memberUUID;
	private final String nickname;

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
