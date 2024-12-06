package com.promptoven.profileservice.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Unwrapped.Nullable;

import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

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
	@Nullable
	private String banner;
	@Nullable
	private String profileImage;
	@Nullable
	private String hashtag;
	@Nullable
	private String bio;
	@Nullable
	private String email;
	private String nickname;
	private LocalDateTime createdAt;
	private boolean isWithdrew;
	private boolean isBanned;
	private boolean isCreator;

	public static Profile createProfile(ProfileModelDTO profileModelDTO) {
		return Profile.builder()
			.memberUUID(profileModelDTO.getMemberUUID())
			.nickname(profileModelDTO.getNickname())
			.createdAt(LocalDateTime.now())

			.banner(null != profileModelDTO.getBanner() ? profileModelDTO.getBanner() : "")
			.profileImage(null != profileModelDTO.getProfileImage() ? profileModelDTO.getProfileImage() : "")
			.hashtag(null != profileModelDTO.getHashtag() ? profileModelDTO.getHashtag() : null)
			.bio(null != profileModelDTO.getBio() ? profileModelDTO.getBio() : null)
			.email(null != profileModelDTO.getEmail() ? profileModelDTO.getEmail() : null)

			.isWithdrew(false)
			.isBanned(false)
			.isCreator(false)

			.build();
	}

	public static boolean isViewable(Profile profile) {
		return !(profile.isWithdrew() || profile.isBanned());
	}

	public static Profile acceptWithdraw(Profile profile) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.createdAt(profile.getCreatedAt())

			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.hashtag(profile.getHashtag())
			.bio(profile.getBio())
			.email(profile.getEmail())

			.isWithdrew(true)
			.isBanned(profile.isBanned())
			.isCreator(profile.isCreator())

			.build();
	}

	public static Profile banProfile(Profile profile) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.createdAt(profile.getCreatedAt())

			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.hashtag(profile.getHashtag())
			.bio(profile.getBio())
			.email(profile.getEmail())

			.isWithdrew(profile.isWithdrew())
			.isBanned(true)
			.isCreator(profile.isCreator())

			.build();
	}

	public static Profile updateProfile(Profile profile, ProfileModelDTO profileModelDTO) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.createdAt(profile.getCreatedAt())

			.banner(null != profileModelDTO.getBanner() ? profileModelDTO.getBanner() : profile.getBanner())
			.profileImage(null != profileModelDTO.getProfileImage() ? profileModelDTO.getProfileImage() :
				profile.getProfileImage())
			.hashtag(null != profileModelDTO.getHashtag() ? profileModelDTO.getHashtag() : profile.getHashtag())
			.bio(null != profileModelDTO.getBio() ? profileModelDTO.getBio() : profile.getBio())
			.email(null != profileModelDTO.getEmail() ? profileModelDTO.getEmail() : profile.getEmail())

			.isWithdrew(profile.isWithdrew())
			.isBanned(profile.isBanned())
			.isCreator(profile.isCreator())

			.build();
	}

	public static Profile updateNickname(Profile profile, String nickname) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(nickname)
			.createdAt(profile.getCreatedAt())

			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.hashtag(profile.getHashtag())
			.bio(profile.getBio())
			.email(profile.getEmail())

			.isWithdrew(profile.isWithdrew())
			.isBanned(profile.isBanned())
			.isCreator(profile.isCreator())

			.build();
	}

	public static Profile unban(Profile profile) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.createdAt(profile.getCreatedAt())

			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.hashtag(profile.getHashtag())
			.bio(profile.getBio())
			.email(profile.getEmail())

			.isWithdrew(profile.isWithdrew())
			.isBanned(false)
			.isCreator(profile.isCreator())

			.build();
	}

	public static Profile promotedToCreator(Profile profile) {
		return Profile.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.createdAt(profile.getCreatedAt())

			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.hashtag(profile.getHashtag())
			.bio(profile.getBio())
			.email(profile.getEmail())

			.isWithdrew(profile.isWithdrew())
			.isBanned(profile.isBanned())
			.isCreator(true)

			.build();
	}
}
