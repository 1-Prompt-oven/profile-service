package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileCountVO {
	private int followerCount;
	private int followingCount;
	private int viewerCount;
	private int salesCount;

}
