package com.promptoven.profileservice.application.service.dto.mapper;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

@Component
public class ProfileDomainDTOMapper implements DomainDTOMapper<Profile, ProfileDTO> {

	@Override
	public ProfileDTO toDTO(Profile domain) {
		return ProfileDTO.builder()
			.memberUUID(domain.getMemberUUID())
			.nickname(domain.getNickname())
			.createdAt(domain.getCreatedAt())
			.banner(domain.getBanner())
			.profileImage(domain.getProfileImage())
			.bio(domain.getBio())
			.hashtag(domain.getHashtag())
			.email(domain.getEmail())
			.build();
	}

	@Override
	public Profile toDomain(ProfileDTO dto) {
		return Profile.builder()
			.memberUUID(dto.getMemberUUID())
			.nickname(dto.getNickname())
			.createdAt(dto.getCreatedAt())
			.banner(dto.getBanner())
			.profileImage(dto.getProfileImage())
			.bio(dto.getBio())
			.hashtag(dto.getHashtag())
			.email(dto.getEmail())
			.build();
	}

	public ProfileModelDTO toUpdateModelDTO(ProfileUpdateRequestDTO dto) {
		return ProfileModelDTO.builder()
			.memberUUID(dto.getMemberUUID())
			.banner(dto.getBanner())
			.profileImage(dto.getProfileImage())
			.hashtag(dto.getHashtag())
			.bio(dto.getBio())
			.email(dto.getEmail())
			.nickname(dto.getNickname())
			.build();
	}

	public ProfileShortDTO toShortDTO(ProfileDTO dto) {
		return ProfileShortDTO.builder()
			.memberUUID(dto.getMemberUUID())
			.nickname(dto.getNickname())
			.profileImage(dto.getProfileImage())
			.build();
	}
}
