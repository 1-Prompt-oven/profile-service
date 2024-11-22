package com.promptoven.profileservice.application;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;
import com.promptoven.profileservice.application.out.call.FollowingPersistence;
import com.promptoven.profileservice.domain.Following;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.FollowingModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileCommonService implements ProfileUseCase {

	private final FollowingPersistence followingPersistence;

	@Override
	public void follow(String profileId, String followerId) {
		FollowingModelDTO followingModelDTO = FollowingModelDTO.builder()
			.FollowerID(followerId)
			.FolloweeID(profileId)
			.build();
		Following following = Following.CreateFollowing(followingModelDTO);
		followingPersistence.save(following);
	}

	@Override
	public void unfollow(String nickname, String followerId) {

	}

	@Override
	public void updateProfile(ProfileDTO profileDTO) {

	}

	@Override
	public ProfileDTO getProfile(String nickname) {
		return null;
	}

	@Override
	public Collection<Object> getFollowers(String nickname) {
		return List.of();
	}

	@Override
	public Collection<Object> getFollowing(String nickname) {
		return List.of();
	}

	@Override
	public Object getProfileCount(String nickname) {
		return null;
	}

	@Override
	public void alarm(String nickname) {

	}

	@Override
	public void alarm(String nickname, String alarmId) {

	}

	@Override
	public void withdrawProfile(String memberUUID) {

	}

	@Override
	public void banProfile(String memberUUID, String reason) {

	}

	@Override
	public ProfileDTO getProfileByMemberUUID(String memberUUID) {
		return null;
	}

	@Override
	public Collection<ProfileDTO> getTopCreators() {
		return List.of();
	}

	@Override
	public void createProfile(Profile profile) {

	}
}
