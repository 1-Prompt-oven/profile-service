package com.promptoven.profileservice.application.in.usecase;

import java.util.Collection;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;
import com.promptoven.profileservice.domain.Profile;

public interface ProfileUseCase {

	void follow(String profileId, String followerId);

	void unfollow(String nickname, String followerId);

	void updateProfile(ProfileDTO profileDTO);

	ProfileDTO getProfile(String nickname);

	Collection<Object> getFollowers(String nickname);

	Collection<Object> getFollowing(String nickname);

	Object getProfileCount(String nickname);

	void alarm(String nickname);

	void alarm(String nickname, String alarmId);

	Collection<ProfileDTO> getTopCreators();

	void createProfile(Profile profile);

	void withdrawProfile(String memberUUID);

	void banProfile(String memberUUID, String reason);

	ProfileDTO getProfileByMemberUUID(String memberUUID);
}
