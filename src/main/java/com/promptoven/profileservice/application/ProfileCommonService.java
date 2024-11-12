package com.promptoven.profileservice.application;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileCommonService implements ProfileUseCase {

	@Override
	public void follow(String profileId, String followerId) {
		// TODO Auto-generated method stub
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
	public Collection<ProfileDTO> getTopCreators() {
		return List.of();
	}
}
