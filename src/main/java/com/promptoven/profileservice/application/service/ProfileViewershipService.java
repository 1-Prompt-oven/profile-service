package com.promptoven.profileservice.application.service;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.usecase.ProfileViewershipUsecase;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileViewershipMemory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileViewershipService implements ProfileViewershipUsecase {

	private final ProfileViewershipMemory profileViewershipMemory;
	private final ProfilePersistence profilePersistence;
	private final ProfileStatisticsPersistence profileStatisticsPersistence;

	@Override
	public void addViewCount(String profileId) {
		profileViewershipMemory.addViewCount(profileId);
	}

	@Override
	public void addViewCountByNickname(String nickname) {
		String profileId = profilePersistence.getProfileID(nickname);
		if (profileId != null) {
			profileViewershipMemory.addViewCount(profileId);
		}

	}

	@Override
	public void applyViewCounts(String profileId) {
		Long accumulatedCount = profileViewershipMemory.getAndResetViewCount(profileId);
		if (accumulatedCount > 0) {
			profileStatisticsPersistence.addProfileViewCount(profileId, accumulatedCount);
		}
	}
}
