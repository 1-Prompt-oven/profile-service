package com.promptoven.profileservice.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileShortDTO {

	private String memberUUID;
	private String nickname;
	private String profileImage;
}
