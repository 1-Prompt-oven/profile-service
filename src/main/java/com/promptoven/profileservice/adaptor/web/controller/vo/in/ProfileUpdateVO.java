package com.promptoven.profileservice.adaptor.web.controller.vo.in;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateVO {
	private String memberUUID;
	private String nickname;

	@Nullable
	private String xId;
	@Nullable
	private String instagramId;
	@Nullable
	private String youtubeHandle;
	@Nullable
	private String webLink;
	@Nullable
	private String bio;
	@Nullable
	private String bannerImageUrl;
	@Nullable
	private String avatarImageUrl;
	@Nullable
	private String hashTag;
	@Nullable
	private String email;

}
