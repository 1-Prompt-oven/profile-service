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

	public static Profile updateProfile(Profile oldProfile, @Nullable String XId, @Nullable String instagramId,
		@Nullable String youtubeHandle, @Nullable String webLink, @Nullable String bio) {
		return Profile.builder()
			.memberUUID(oldProfile.getMemberUUID())
			.nickname(oldProfile.getNickname())
			.xId(XId != null ? XId : oldProfile.getXId())
			.instagramId(instagramId != null ? instagramId : oldProfile.getInstagramId())
			.youtubeHandle(youtubeHandle != null ? youtubeHandle : oldProfile.getYoutubeHandle())
			.webLink(webLink != null ? webLink : oldProfile.getWebLink())
			.bio(bio != null ? bio : oldProfile.getBio())
			.banner(oldProfile.getBanner())
			.profileImage(oldProfile.getProfileImage())
			.isCreator(oldProfile.isCreator())
			.status(oldProfile.getStatus())
			.visibility(oldProfile.getVisibility())
			.followerCount(oldProfile.getFollowerCount())
			.followingCount(oldProfile.getFollowingCount())
			.bannedAt(oldProfile.getBannedAt())
			.withdrawnAt(oldProfile.getWithdrawnAt())
			.banReason(oldProfile.getBanReason())
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

	public static Profile ban(Profile profile, String reason) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.xId(profile.getXId())
			.instagramId(profile.getInstagramId())
			.youtubeHandle(profile.getYoutubeHandle())
			.webLink(profile.getWebLink())
			.bio(profile.getBio())
			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.isCreator(profile.isCreator())
			.status(ProfileStatus.BANNED)
			.visibility(ProfileVisibility.HIDDEN)
			.followerCount(profile.getFollowerCount())
			.followingCount(profile.getFollowingCount())
			.bannedAt(LocalDateTime.now())
			.withdrawnAt(profile.getWithdrawnAt())
			.banReason(reason)
			.build();
	}

	public static Profile withdraw(Profile profile) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.xId(profile.getXId())
			.instagramId(profile.getInstagramId())
			.youtubeHandle(profile.getYoutubeHandle())
			.webLink(profile.getWebLink())
			.bio(profile.getBio())
			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.isCreator(profile.isCreator())
			.status(ProfileStatus.WITHDRAWN)
			.visibility(ProfileVisibility.HIDDEN)
			.followerCount(profile.getFollowerCount())
			.followingCount(profile.getFollowingCount())
			.bannedAt(profile.getBannedAt())
			.withdrawnAt(LocalDateTime.now())
			.banReason(profile.getBanReason())
			.build();
	}

}
