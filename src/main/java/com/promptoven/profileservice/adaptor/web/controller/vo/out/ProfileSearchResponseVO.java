package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ProfileSearchResponseVO {

	private final String backgroundImg;
	private final String thumbnail;
	private final String nickname;
	private final Long rank;
	private final Double rating;
	private final Long follower;
	private final String id;

}