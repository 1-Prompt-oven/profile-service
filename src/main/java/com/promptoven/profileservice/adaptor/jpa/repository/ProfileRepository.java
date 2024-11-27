package com.promptoven.profileservice.adaptor.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

	ProfileEntity findByMemberUUID(String memberUUID);

	ProfileEntity findByNickname(String nickname);

	List<ProfileEntity> findByNicknameContaining(String nickname);

	List<ProfileEntity> findByBioContaining(String bio);

	List<ProfileEntity> findByHashtagContaining(String hashtag);
}
