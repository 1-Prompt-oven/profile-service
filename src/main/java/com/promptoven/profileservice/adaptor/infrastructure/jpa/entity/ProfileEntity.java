package com.promptoven.profileservice.adaptor.infrastructure.jpa.entity;

import org.springframework.lang.Nullable;

import com.promptoven.profileservice.domain.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

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

	public static ProfileEntity fromDomain(Profile profile) {
		return ProfileEntity.builder()
			.memberUUID(profile.getMemberUUID())
			.nickname(profile.getNickname())
			.xId(profile.getXId())
			.instagramId(profile.getInstagramId())
			.youtubeHandle(profile.getYoutubeHandle())
			.webLink(profile.getWebLink())
			.bio(profile.getBio())
			.banner(profile.getBanner())
			.profileImage(profile.getProfileImage())
			.build();
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public Profile toDomain() {
		return Profile.builder()
			.memberUUID(memberUUID)
			.nickname(nickname)
			.xId(xId)
			.instagramId(instagramId)
			.youtubeHandle(youtubeHandle)
			.webLink(webLink)
			.bio(bio)
			.banner(banner)
			.profileImage(profileImage)
			.build();
	}
}
