package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ProfileSearchResponseVO {

	private final String thumbnail;
	private final String nickname;
	private final String id;

}