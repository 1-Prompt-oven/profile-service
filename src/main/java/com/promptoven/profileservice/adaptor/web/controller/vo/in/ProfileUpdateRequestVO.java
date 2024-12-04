package com.promptoven.profileservice.adaptor.web.controller.vo.in;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateRequestVO {
	private String memberUUID;
	private String bannerImageUrl;
	private String avatarImageUrl;

	@Nullable
	private String hashTag;
	@Nullable
	private String bio;
	@Nullable
	private String email;

	private String nickname;

}
