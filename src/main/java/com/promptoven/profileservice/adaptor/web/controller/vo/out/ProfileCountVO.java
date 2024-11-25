package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import com.promptoven.profileservice.application.service.dto.ProfileDTO;

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

	public static ProfileCountVO fromDTO(Object profileCount) {
		if (profileCount instanceof ProfileDTO) {
			ProfileDTO dto = (ProfileDTO)profileCount;
			return ProfileCountVO.builder()
				.followerCount(dto.getFollowerCount())
				.followingCount(dto.getFollowingCount())
				.viewerCount(dto.getViewerCount())
				.salesCount(dto.getSalesCount())
				.build();
		}
		return null;
	}
}
