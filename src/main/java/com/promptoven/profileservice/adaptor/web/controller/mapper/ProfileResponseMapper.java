package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileResponseVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileSearchResponseVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileShortResponseVO;
import com.promptoven.profileservice.application.port.in.dto.ProfileResponseDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

public class ProfileResponseMapper {
	public static ProfileResponseVO toVO(ProfileResponseDTO profileDTO) {
		return ProfileResponseVO.builder()
			.memberUUID(profileDTO.getMemberUUID())
			.nickname(profileDTO.getNickname())
			.bio(profileDTO.getBio())
			.bannerImageUrl(profileDTO.getBanner())
			.email(profileDTO.getEmail())
			.avatarImageUrl(profileDTO.getProfileImage())
			.sales(profileDTO.getSales())
			.follower(profileDTO.getFollower())
			.following(profileDTO.getFollowing())
			.hashtag(profileDTO.getHashtag())
			.joined(profileDTO.getCreatedAt())
			.viewer(profileDTO.getViewer())
			.build();
	}

	public static ProfileSearchResponseVO toSearchVO(ProfileShortDTO dto) {
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
