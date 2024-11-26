package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ProfileShortResponseVO {

	private final String memberUuid;
	private final String memberProfileImage;
	private final String memberNickname;
	
}
