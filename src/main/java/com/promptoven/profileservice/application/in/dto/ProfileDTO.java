package com.promptoven.profileservice.application.in.dto;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.Profile.ProfileStatus;
import com.promptoven.profileservice.domain.Profile.ProfileVisibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class ProfileDTO {
	private String memberUUID;
	private String nickname;
	@Nullable
	private String xId;
	@Nullable
	private String instagramId;
	@Nullable
	private String youtubeHandle;
	@Nullable
	private String webLink;
	@Nullable
	private String bio;
	@Nullable
	private String banner;
	@Nullable
	private String profileImage;

	private boolean isCreator;
	private ProfileStatus status;
	private ProfileVisibility visibility;
	
	private int followerCount;
	private int followingCount;
	
	@Nullable
	private LocalDateTime bannedAt;
	@Nullable
	private LocalDateTime withdrawnAt;
	
	@Nullable
	private String hashTag;
	@Nullable
	private String email;
	
	private LocalDateTime createdAt;
	private int viewerCount;
	private int salesCount;
	
	public static ProfileDTO fromDomain(Profile profile) {
		if (profile == null) return null;
		
		return ProfileDTO.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.xId(profile.getXId())
			.instagramId(profile.getInstagramId())
			.youtubeHandle(profile.getYoutubeHandle())
			.webLink(profile.getWebLink())
			.bio(profile.getBio())
			.banner(profile.getBannerImageUrl())
			.profileImage(profile.getAvatarImageUrl())
			.isCreator(profile.isCreator())
			.status(profile.getStatus())
			.visibility(profile.getVisibility())
			.followerCount(profile.getFollowerCount())
			.followingCount(profile.getFollowingCount())
			.bannedAt(profile.getBannedAt())
			.withdrawnAt(profile.getWithdrawnAt())
			.hashTag(profile.getHashTag())
			.email(profile.getEmail())
			.createdAt(profile.getCreatedAt())
			.viewerCount(profile.getViewerCount())
			.salesCount(profile.getSalesCount())
			.build();
	}
}
