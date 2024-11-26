package com.promptoven.profileservice.adaptor.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promptoven.profileservice.adaptor.jpa.repository.ProfileStatisticsRepository;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileStatisticsPersistenceByJpa implements ProfileStatisticsPersistence {

	private final ProfileStatisticsRepository profileStatisticsRepository;

	@Override
	@Transactional
	public void addProfileViewCount(String profileUUID, Long count) {
		profileStatisticsRepository.addProfileViewCount(profileUUID, count);
	}
}
