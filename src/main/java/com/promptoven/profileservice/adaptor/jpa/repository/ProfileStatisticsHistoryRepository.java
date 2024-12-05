package com.promptoven.profileservice.adaptor.jpa.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsHistoryEntity;

public interface ProfileStatisticsHistoryRepository extends JpaRepository<ProfileStatisticsHistoryEntity, Long> {

	ProfileStatisticsHistoryEntity findByMemberUUIDAndTargetDate(String memberUUID,
		LocalDate targetDate);
}