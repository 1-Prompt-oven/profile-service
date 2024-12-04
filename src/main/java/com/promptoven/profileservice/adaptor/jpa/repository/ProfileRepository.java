package com.promptoven.profileservice.adaptor.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

	ProfileEntity findByMemberUUID(String memberUUID);

	ProfileEntity findByNickname(String nickname);

	List<ProfileEntity> findByNicknameContaining(String nickname);

	List<ProfileEntity> findByBioContaining(String bio);

	List<ProfileEntity> findByHashtagContaining(String hashtag);

	@Query("SELECT p.memberUUID FROM ProfileEntity p where p.isWithdrew=false and p.isBanned = false")
	List<String> findAllProfileIDs();

	@Query("select p.profileImage From ProfileEntity p where p.memberUUID = :memberUUID and p.isWithdrew=false and p.isBanned = false")
	String findPictureByID(String memberUUID);

	@Query("select p.memberUUID From ProfileEntity p where p.nickname = :nickname and p.isWithdrew=false and p.isBanned = false")
	String findIDByNickname(String nickname);
}
