package com.promptoven.profileservice.application.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.usecase.ProfileStatisticsHistoryUsecase;
import com.promptoven.profileservice.application.port.out.call.FollowingPersistence;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsHistoryPersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileStatisticsDomainDTOMapper;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileStatisticsHistoryDomainDTOMapper;
import com.promptoven.profileservice.domain.ProfileStatisticsHistory;
import com.promptoven.profileservice.domain.dto.ProfileStatisticsModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileStatisticsHistoryService implements ProfileStatisticsHistoryUsecase {

	private final ProfilePersistence profilePersistence;
	private final ProfileStatisticsPersistence profileStatisticsPersistence;
	private final ProfileStatisticsDomainDTOMapper profileStatisticsDomainDTOMapper;
	private final ProfileStatisticsHistoryDomainDTOMapper profileStatisticsHistoryDomainDTOMapper;
	private final FollowingPersistence followingPersistence;
	private final ProfileStatisticsHistoryPersistence profileStatisticsHistoryPersistence;

	@Scheduled(cron = "0 0 4 * * *") // Runs at 04:00 UTC daily
	private void recordDailyStatistics() {
		profilePersistence.getAllProfileIDs()
			.forEach(profileId -> CompletableFuture.runAsync(() -> recordDailyProfileStatistics(profileId)));
	}

	private void recordDailyProfileStatistics(String profileID) {
		ProfileStatisticsDTO profileStatisticsDTO = profileStatisticsPersistence.get(profileID);
		ProfileStatisticsModelDTO profileStatisticsModelDTO = profileStatisticsDomainDTOMapper.toModelDTO(
			profileStatisticsDTO);
		Long follower = followingPersistence.countFollowers(profileID);
		ProfileStatisticsHistory profileStatisticsHistory = ProfileStatisticsHistory.create(profileStatisticsModelDTO,
			follower);
		profileStatisticsHistoryPersistence.record(
			profileStatisticsHistoryDomainDTOMapper.toDTO(profileStatisticsHistory));
	}

	@Override
	public ProfileStatisticsHistoryDTO getProfileStatisticsHistory(String memberUUID, LocalDate targetDate) {
		return profileStatisticsHistoryPersistence.get(targetDate, memberUUID);
	}
}
