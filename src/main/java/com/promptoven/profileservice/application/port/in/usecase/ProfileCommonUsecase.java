package com.promptoven.profileservice.application.port.in.usecase;

import java.util.List;

import com.promptoven.profileservice.application.port.in.dto.ProfileResponseDTO;
import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

public interface ProfileCommonUsecase {

	ProfileResponseDTO get(String memberUUID);

	ProfileResponseDTO getByNickname(String nickname);

	void update(ProfileUpdateRequestDTO profileUpdateRequestDTO);

	ProfileShortDTO getShort(String memberUUID);

	ProfileShortDTO getShortByNickname(String nickname);

	List<ProfileShortDTO> search(String query);
}
