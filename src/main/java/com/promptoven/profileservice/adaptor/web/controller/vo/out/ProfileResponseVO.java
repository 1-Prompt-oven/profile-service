package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfileResponseVO {
	private final String memberUUID;
	private final String bannerImageUrl;
	private final String avatarImageUrl;
	private final String hashTag;
	private final String bio;
	private final String email;
	private final String nickname;
	private final LocalDateTime joined;
	private final Long following;
	private final Long follower;
	private final Long viewer;
	private final Long sales;

}
