package com.promptoven.profileservice.adaptor.jpa;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

class JpaProfileDTOEntityMapper {

	static ProfileEntity toEntity(ProfileDTO dto) {
		return ProfileEntity.builder()
			.memberUUID(dto.getMemberUUID())
			.banner(dto.getBanner())
			.profileImage(dto.getProfileImage())
			.hashtag(dto.getHashtag())
			.bio(dto.getBio())
			.email(dto.getEmail())
			.nickname(dto.getNickname())
			.createdAt(dto.getCreatedAt())
			.isWithdrew(dto.isWithdrew())
			.isBanned(dto.isBanned())
			.isCreator(dto.isCreator())
			.build();
	}

	static ProfileDTO toDTO(ProfileEntity entity) {
		return ProfileDTO.builder()
			.memberUUID(entity.getMemberUUID())
			.banner(entity.getBanner())
			.profileImage(entity.getProfileImage())
			.hashtag(entity.getHashtag())
			.bio(entity.getBio())
			.email(entity.getEmail())
			.nickname(entity.getNickname())
			.createdAt(entity.getCreatedAt())
			.isBanned(entity.isBanned())
			.isCreator(entity.isCreator())
			.isWithdrew(entity.isWithdrew())
			.build();
	}

}
