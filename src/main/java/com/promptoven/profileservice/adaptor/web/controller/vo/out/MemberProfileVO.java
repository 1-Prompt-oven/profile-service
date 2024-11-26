package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemberProfileVO {
	private String memberUUID;
	private String nickname;

	@Nullable
	private String avatarImageUrl;
	@Nullable
	private String hashTag;

	private int followerCount;
	private int followingCount;

	@Nullable
	private String bio;

}