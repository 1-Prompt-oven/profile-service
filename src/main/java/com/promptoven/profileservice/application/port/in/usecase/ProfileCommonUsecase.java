package com.promptoven.profileservice.application.port.in.usecase;

import java.util.List;

import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

public interface ProfileCommonUsecase {

	ProfileDTO get(String memberUUID);

	ProfileDTO getByNickname(String nickname);

	void update(ProfileUpdateRequestDTO profileUpdateRequestDTO);

	ProfileShortDTO getShort(String memberUUID);

	ProfileShortDTO getShortByNickname(String nickname);

	List<ProfileShortDTO> search(String query);
}
