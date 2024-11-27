package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileResponseVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileSearchResponseVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileShortResponseVO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileSearchResultDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

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

	public static ProfileSearchResponseVO toSearchVO(ProfileSearchResultDTO dto) {
		return ProfileSearchResponseVO.builder()
			.id(dto.getMemberUUID())
			.nickname(dto.getNickname())
			.thumbnail(dto.getProfileImage())
			.build();
	}

	public static ProfileShortResponseVO toShortVO(ProfileShortDTO dto) {
		return ProfileShortResponseVO.builder()
			.memberUuid(dto.getMemberUUID())
			.memberNickname(dto.getNickname())
			.memberProfileImage(dto.getProfileImage())
			.build();
	}
}
