package com.promptoven.profileservice.application.port.out.call;

import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import java.util.List;

public interface ProfilePersistence {

	void create(ProfileDTO profileDTO);

	ProfileDTO read(String profileID);

	void update(ProfileDTO profileDTO);

	String getProfileID(String nickname);

	List<String> getAllProfileIDs();
}
