package com.promptoven.profileservice.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
	private String memberUUID;
	private String nickname;
	private String xId;
	private String instagramId;
	private String youtubeHandle;
	private String webLink;
	private String bio;
	private String bannerImageUrl;
	private String avatarImageUrl;
	private String hashTag;
	private String email;
	
	private boolean isCreator;
	private ProfileStatus status;
	private ProfileVisibility visibility;
	
	private int followerCount;
	private int followingCount;
	private int viewerCount;
	private int salesCount;
	
	private LocalDateTime bannedAt;
	private LocalDateTime withdrawnAt;
	private LocalDateTime createdAt;
	private String banReason;

	public enum ProfileStatus {
		ACTIVE,
		BANNED,
		WITHDRAWN
	}

	public enum ProfileVisibility {
		PUBLIC,
		PRIVATE,
		HIDDEN
	}

	public static Profile createProfile(String memberUUID, String nickname, boolean isCreator) {
		return Profile.builder()
			.memberUUID(memberUUID)
			.nickname(nickname)
			.isCreator(isCreator)
			.status(ProfileStatus.ACTIVE)
			.visibility(isCreator ? ProfileVisibility.PUBLIC : ProfileVisibility.PRIVATE)
			.followerCount(0)
			.followingCount(0)
			.viewerCount(0)
			.salesCount(0)
			.createdAt(LocalDateTime.now())
			.build();
	}
}
