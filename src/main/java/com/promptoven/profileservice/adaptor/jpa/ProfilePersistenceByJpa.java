package com.promptoven.profileservice.adaptor.jpa;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfilePersistenceByJpa implements ProfilePersistence {

	@Override
	public void create(ProfileDTO profileDTO) {

	}

	@Override
	public ProfileDTO read(String profileID) {
		return null;
	}

	@Override
	public void update(ProfileDTO profileDTO) {

	}

	@Override
	public String getProfileID(String nickname) {
		return "";
	}
}
