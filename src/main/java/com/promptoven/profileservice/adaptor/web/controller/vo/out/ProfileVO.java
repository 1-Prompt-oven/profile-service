package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.domain.Profile.ProfileStatus;
import com.promptoven.profileservice.domain.Profile.ProfileVisibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileVO {
	private String memberUUID;
	private String nickname;

	@Nullable
	private String bannerImageUrl;
	@Nullable
	private String avatarImageUrl;
	@Nullable
	private String hashTag;
	@Nullable
	private String bio;
	@Nullable
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime joined;

	private int following;
	private int follower;
	private int viewer;
	private int sales;

	private boolean isViewStatus;

	public static ProfileVO fromDTO(ProfileDTO profileDTO) {
		if (profileDTO == null ||
			profileDTO.getStatus() == ProfileStatus.WITHDRAWN ||
			(profileDTO.getStatus() == ProfileStatus.BANNED && profileDTO.getVisibility() == ProfileVisibility.HIDDEN)
			||
			(profileDTO.getVisibility() == ProfileVisibility.PRIVATE && !profileDTO.isCreator())) {
			return null;
		}

		return ProfileVO.builder()
			.memberUUID(profileDTO.getMemberUUID())
			.nickname(profileDTO.getNickname())
			.bannerImageUrl(profileDTO.getBanner())
			.avatarImageUrl(profileDTO.getProfileImage())
			.hashTag(profileDTO.getHashTag())
			.bio(profileDTO.getBio())
			.email(profileDTO.getEmail())
			.joined(profileDTO.getCreatedAt())
			.following(profileDTO.getFollowingCount())
			.follower(profileDTO.getFollowerCount())
			.viewer(profileDTO.getViewerCount())
			.sales(profileDTO.getSalesCount())
			.isViewStatus(profileDTO.isCreator())
			.build();
	}
}
