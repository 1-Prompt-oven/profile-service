package com.promptoven.profileservice.application.service.dto.mapper;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.port.in.dto.ProfileResponseDTO;
import com.promptoven.profileservice.application.service.dto.FollowStatDTO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;

@Component
public class ProfileResponseDTOMapper {

	public ProfileResponseDTO toDTO(ProfileDTO profileDTO, ProfileStatisticsDTO profileStatisticsDTO,
		FollowStatDTO followStatDTO) {
		return ProfileResponseDTO.builder()
			.memberUUID(profileDTO.getMemberUUID())
			.nickname(profileDTO.getNickname())
			.createdAt(profileDTO.getCreatedAt())
			.banner(profileDTO.getBanner())
			.profileImage(profileDTO.getProfileImage())
			.bio(profileDTO.getBio())
			.hashtag(profileDTO.getHashtag())
			.email(profileDTO.getEmail())
			.sales(profileStatisticsDTO.getSales())
			.following(followStatDTO.getFollowing())
			.follower(followStatDTO.getFollower())
			.viewer(profileStatisticsDTO.getViewer())
			.build();
	}
}
