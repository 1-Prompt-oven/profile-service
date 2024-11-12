package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileCountVO {
	private int followerCount;
	private int followingCount;
	
	public static ProfileCountVO fromDTO(Object profileCount) {
		if (profileCount instanceof ProfileDTO) {
			ProfileDTO dto = (ProfileDTO) profileCount;
			return ProfileCountVO.builder()
				.followerCount(dto.getFollowerCount())
				.followingCount(dto.getFollowingCount())
				.build();
		}
		return null;
	}
}
