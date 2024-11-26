package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileResponseVO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

public class ProfileResponseMapper {
	public static ProfileResponseVO toVO(ProfileDTO dto) {
		return ProfileResponseVO.builder()
			.memberUUID(dto.getMemberUUID())
			.nickname(dto.getNickname())
			.bio(dto.getBio())
			.bannerImageUrl(dto.getBanner())
			.email(dto.getEmail())
			.avatarImageUrl(dto.getProfileImage())
			.sales(0L)
			.follower(0L)
			.following(0L)
			.nickname(dto.getHashtag())
			.joined(dto.getCreatedAt())
			.viewer(0L)
			.build();
	}
}
