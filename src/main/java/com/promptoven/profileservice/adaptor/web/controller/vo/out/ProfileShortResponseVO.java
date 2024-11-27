package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfileShortResponseVO {

	private final String memberUuid;
	private final String memberProfileImage;
	private final String memberNickname;

}
