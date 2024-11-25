package com.promptoven.profileservice.application.service.dto.mapper;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.service.dto.FollowingDTO;
import com.promptoven.profileservice.domain.Following;

@Component
public class FollowingDomainDTOMapper implements DomainDTOMapper<Following, FollowingDTO> {

	@Override
	public FollowingDTO toDTO(Following domain) {
		return FollowingDTO.builder()
			.FollowDate(domain.getFollowDate())
			.UnfollowDate(domain.getUnfollowDate())
			.follower(domain.getFollower())
			.followee(domain.getFollowee())
			.build();
	}

	@Override
	public Following toDomain(FollowingDTO dto) {
		return Following.builder()
			.FollowDate(dto.getFollowDate())
			.UnfollowDate(dto.getUnfollowDate())
			.follower(dto.getFollower())
			.followee(dto.getFollowee())
			.build();
	}
}
