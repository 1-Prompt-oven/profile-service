package com.promptoven.profileservice.application.service;

import org.springframework.scheduling.annotation.Scheduled;
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

	@Scheduled(fixedRate = 60000 * 60) // Runs every 1 hour
	public void applyAllProfileViewCounts() {
		log.info("Starting scheduled profile view count application");
		try {
			profilePersistence.getAllProfileIDs().forEach(this::applyViewCounts);
			log.info("Completed scheduled profile view count application");
		} catch (Exception e) {
			log.error("Error during scheduled profile view count application", e);
		}
	}
}