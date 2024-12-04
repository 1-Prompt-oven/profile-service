package com.promptoven.profileservice.adaptor.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

	@Query("select p from ProfileEntity  p where p.memberUUID = :memberUUID and p.isWithdrew=false and p.isBanned = false")
	ProfileEntity findByMemberUUID(String memberUUID);

	@Query("select p from ProfileEntity p where p.nickname = :nickname and p.isBanned=false and p.isWithdrew=false")
	ProfileEntity findByNickname(String nickname);

	List<ProfileEntity> findByNicknameContaining(String nickname);

	List<ProfileEntity> findByBioContaining(String bio);

	List<ProfileEntity> findByHashtagContaining(String hashtag);

	@Query("SELECT p.memberUUID FROM ProfileEntity p")
	List<String> findAllProfileIDs();

	@Query("select p.profileImage From ProfileEntity p where p.memberUUID = :memberUUID")
	String findPictureByID(String memberUUID);
}
