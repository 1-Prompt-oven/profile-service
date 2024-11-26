package com.promptoven.profileservice.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileSearchResultDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileCommonService implements ProfileCommonUsecase {
	
	@Override
	public ProfileDTO get(String memberUUID) {
		return null;
	}

	@Override
	public ProfileDTO getByNickname(String nickname) {
		return null;
	}

	@Override
	public void update(ProfileUpdateRequestDTO profileUpdateRequestDTO) {

	}

	@Override
	public ProfileShortDTO getShort(String memberUUID) {
		return null;
	}

	@Override
	public ProfileShortDTO getShortByNickname(String nickname) {
		return null;
	}

	@Override
	public List<ProfileSearchResultDTO> search(String query) {
		return List.of();
	}
}
