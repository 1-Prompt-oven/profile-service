package com.promptoven.profileservice.domain;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

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

	public boolean isAccessible() {
		return status == ProfileStatus.ACTIVE &&
			(visibility == ProfileVisibility.PUBLIC || 
			(visibility == ProfileVisibility.PRIVATE && isCreator));
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
			.build();
	}

	public static Profile updateBio(Profile oldProfile, String bio) {
		return Profile.builder()
			.memberUUID(oldProfile.getMemberUUID())
			.nickname(oldProfile.getNickname())
			.xId(oldProfile.getXId())
			.instagramId(oldProfile.getInstagramId())
			.youtubeHandle(oldProfile.getYoutubeHandle())
			.webLink(oldProfile.getWebLink())
			.bio(bio)
			.banner(oldProfile.getBanner())
			.profileImage(oldProfile.getProfileImage())
			.build();
	}

	// todo: null 기반 3항 연산자로 돌려도 되나? Nullable 걸면 그냥 들어가라 해도 알아서 돌아가려나? 모르겠어요.
	public static Profile updateProfile(Profile oldProfile, @Nullable String XId, @Nullable String instagramId,
		@Nullable String youtubeHandle, @Nullable String webLink, @Nullable String bio) {
		return Profile.builder()
			.memberUUID(oldProfile.getMemberUUID())
			.nickname(oldProfile.getNickname())
			.xId(null != XId ? XId : oldProfile.getXId())
			.instagramId(null != instagramId ? instagramId : oldProfile.getInstagramId())
			.youtubeHandle(null != youtubeHandle ? youtubeHandle : oldProfile.getYoutubeHandle())
			.webLink(null != webLink ? webLink : oldProfile.getWebLink())
			.bio(null != bio ? bio : oldProfile.getBio())
			.banner(oldProfile.getBanner())
			.profileImage(oldProfile.getProfileImage())
			.build();
	}

	public static Profile UpdateBanner(Profile oldProfile, String banner) {
		return Profile.builder()
			.memberUUID(oldProfile.getMemberUUID())
			.nickname(oldProfile.getNickname())
			.xId(oldProfile.getXId())
			.instagramId(oldProfile.getInstagramId())
			.youtubeHandle(oldProfile.getYoutubeHandle())
			.webLink(oldProfile.getWebLink())
			.bio(oldProfile.getBio())
			.banner(banner)
			.profileImage(oldProfile.getProfileImage())
			.build();

	}

	public static Profile UpdateProfileImage(Profile oldProfile, String profileImage) {
		return Profile.builder()
			.memberUUID(oldProfile.getMemberUUID())
			.nickname(oldProfile.getNickname())
			.xId(oldProfile.getXId())
			.instagramId(oldProfile.getInstagramId())
			.youtubeHandle(oldProfile.getYoutubeHandle())
			.webLink(oldProfile.getWebLink())
			.bio(oldProfile.getBio())
			.banner(oldProfile.getBanner())
			.profileImage(profileImage)
			.build();
	}

}
