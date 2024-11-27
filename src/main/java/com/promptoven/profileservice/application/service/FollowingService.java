package com.promptoven.profileservice.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.dto.FollowRequestDTO;
import com.promptoven.profileservice.application.port.in.dto.UnfollowRequestDTO;
import com.promptoven.profileservice.application.port.in.usecase.FollowingUsecase;
import com.promptoven.profileservice.application.port.out.call.FollowingPersistence;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowingService implements FollowingUsecase {

	private final FollowingPersistence followingPersistence;

	@Override
	public void follow(FollowRequestDTO followRequestDTO) {

	}

	@Override
	public void unfollow(UnfollowRequestDTO unfollowRequestDTO) {

	}

	@Override
	public boolean isFollowing(String follower, String followee) {
		return false;
	}

	@Override
	public List<ProfileShortDTO> getFollowers(String followee) {
		return List.of();
	}

	@Override
	public List<ProfileShortDTO> getFollowing(String follower) {
		return List.of();
	}
}
