package com.promptoven.profileservice.application.port.out.call;

import com.promptoven.profileservice.application.service.dto.ProfileDTO;

public interface ProfilePersistence {

	void create(ProfileDTO profileDTO);

	ProfileDTO read(String profileID);

	void update(ProfileDTO profileDTO);

	String getProfileID(String nickname);
}
