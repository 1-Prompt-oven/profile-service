package com.promptoven.profileservice.adaptor.web.controller.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class IsFollowingRequestVO {

	private String follower;
	private String followee;
}
