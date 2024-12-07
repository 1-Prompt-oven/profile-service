package com.promptoven.profileservice.adaptor.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsHistoryEntity;

public interface ProfileStatisticsHistoryRepository extends JpaRepository<ProfileStatisticsHistoryEntity, Long> {

	@Query("select p from ProfileStatisticsHistoryEntity p where p.memberUUID = ?1 and p.targetDate between ?2 and ?3")
	List<ProfileStatisticsHistoryEntity> findByMemberUUIDAndTargetDate(String memberUUID, LocalDate beginDate,
		LocalDate endDate);
}