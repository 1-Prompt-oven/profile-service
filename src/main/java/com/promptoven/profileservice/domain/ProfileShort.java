package com.promptoven.profileservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileShort {

	private String memberUUID;
	private String nickname;
	private String avatarImageUrl;
}
