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

	public static Profile createProfile(ProfileModelDTO profileModelDTO) {
		return Profile.builder()
			.memberUUID(profileModelDTO.getMemberUUID())
			.nickname(profileModelDTO.getNickname())
			.createdAt(LocalDateTime.now())

			.banner(null != profileModelDTO.getBanner() ? profileModelDTO.getBanner() : null)
			.profileImage(null != profileModelDTO.getProfileImage() ? profileModelDTO.getProfileImage() : null)
			.hashtag(null != profileModelDTO.getHashtag() ? profileModelDTO.getHashtag() : null)
			.bio(null != profileModelDTO.getBio() ? profileModelDTO.getBio() : null)
			.email(null != profileModelDTO.getEmail() ? profileModelDTO.getEmail() : null)

			.build();
	}
}
