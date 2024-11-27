package com.promptoven.profileservice.adaptor.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsEntity;

public interface ProfileStatisticsRepository extends JpaRepository<ProfileStatisticsEntity, Long> {

	@Modifying
	@Query("UPDATE ProfileStatisticsEntity p SET p.viewer = p.viewer + :count WHERE p.memberUUID = :profileUUID")
	void addProfileViewCount(String profileUUID, Long count);
	
	ProfileStatisticsEntity findByMemberUUID(String memberUUID);

}
