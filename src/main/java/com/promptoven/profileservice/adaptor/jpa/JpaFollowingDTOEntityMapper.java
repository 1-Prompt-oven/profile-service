package com.promptoven.profileservice.adaptor.jpa;

import com.promptoven.profileservice.adaptor.jpa.entity.FollowingEntity;
import com.promptoven.profileservice.application.service.dto.FollowingDTO;

class JpaFollowingDTOEntityMapper {

	static FollowingEntity toEntity(FollowingDTO dto) {
		return FollowingEntity.builder()
			.follower(dto.getFollower())
			.followee(dto.getFollowee())
			.FollowDate(dto.getFollowDate())
			.UnfollowDate(dto.getUnfollowDate())
			.build();
	}

	static FollowingDTO toDTO(FollowingEntity entity) {
		return FollowingDTO.builder()
			.follower(entity.getFollower())
			.followee(entity.getFollowee())
			.FollowDate(entity.getFollowDate())
			.UnfollowDate(entity.getUnfollowDate())
			.build();
	}
}
