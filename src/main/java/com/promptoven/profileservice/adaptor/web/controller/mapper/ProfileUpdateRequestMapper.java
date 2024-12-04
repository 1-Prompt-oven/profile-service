package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateRequestVO;
import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;

public class ProfileUpdateRequestMapper {

	public static ProfileUpdateRequestDTO toDTO(ProfileUpdateRequestVO vo) {
		return ProfileUpdateRequestDTO.builder()
			.memberUUID(vo.getMemberUUID())
			.banner(vo.getBannerImageUrl())
			.profileImage(vo.getAvatarImageUrl())
			.hashtag(vo.getHashTag())
			.bio(vo.getBio())
			.email(vo.getEmail())
			.nickname(vo.getNickname())
			.build();
	}
}
