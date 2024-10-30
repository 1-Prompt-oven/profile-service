package com.promptoven.profileservice.application.out.call;

import com.promptoven.profileservice.domain.Profile;

public interface ProfilePersistence {

	void CreateProfile(Profile profile);

	void UpdateProfile(Profile profile);

	Profile getProfileByNickname(String nickname);

	Profile getProfileByProfileID(String profileID);

}
