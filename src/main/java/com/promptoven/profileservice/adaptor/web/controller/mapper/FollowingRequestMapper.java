package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.in.FollowRequestVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.in.UnfollowRequestVO;
import com.promptoven.profileservice.application.port.in.dto.FollowRequestDTO;
import com.promptoven.profileservice.application.port.in.dto.UnfollowRequestDTO;

public class FollowingRequestMapper {

	public static FollowRequestDTO toFollowRequestDTO(FollowRequestVO followRequestVO, String creatorNickname) {
		return FollowRequestDTO.builder()
			.FollowerID(followRequestVO.getFollowerId())
			.CreatorNickname(creatorNickname)
			.build();
	}

	public static UnfollowRequestDTO toUnfollowRequestDTO(UnfollowRequestVO unfollowRequestVO, String creatorNickname) {
		return UnfollowRequestDTO.builder()
			.FollowerID(unfollowRequestVO.getFollowerId())
			.CreatorNickname(creatorNickname)
			.build();
	}
}

