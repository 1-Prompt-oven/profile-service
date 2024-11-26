package com.promptoven.profileservice.application.port.in.dto;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileUpdateRequestDTO {

	private final String memberUUID;
	private final String banner;
	private final String profileImage;

	@Nullable
	private final String hashtag;
	@Nullable
	private final String bio;
	@Nullable
	private final String email;

	private final String nickname;

}
