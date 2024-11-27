package com.promptoven.profileservice.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileSearchResultDTO {

	private final String memberUUID;
	private final String profileImage;
	private final String nickname;

}
