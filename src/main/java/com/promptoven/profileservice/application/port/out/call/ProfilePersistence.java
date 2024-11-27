package com.promptoven.profileservice.application.port.out.call;

import java.util.List;

import com.promptoven.profileservice.application.service.dto.ProfileDTO;

public interface ProfilePersistence {

	void create(ProfileDTO profileDTO);

	ProfileDTO read(String profileID);

	void update(ProfileDTO profileDTO);

	String getProfileID(String nickname);

	List<String> getAllProfileIDs();

	ProfileDTO readByNickname(String nickname);

	List<ProfileDTO> search(String query);
}
