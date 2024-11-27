package com.promptoven.profileservice.adaptor.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.adaptor.jpa.entity.FollowingEntity;
import com.promptoven.profileservice.adaptor.jpa.repository.FollowingRepository;
import com.promptoven.profileservice.application.port.out.call.FollowingPersistence;
import com.promptoven.profileservice.application.service.dto.FollowingDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FollowingPersistenceByJpa implements FollowingPersistence {

	private final FollowingRepository followingRepository;

	@Override
	public void follow(FollowingDTO followingDTO) {
		FollowingEntity followingEntity = JpaFollowingDTOEntityMapper.toEntity(followingDTO);
		followingRepository.save(followingEntity);
	}

	@Override
	public void unfollow(FollowingDTO followingDTO) {
		FollowingEntity followingEntity = JpaFollowingDTOEntityMapper.toEntity(followingDTO);
		followingEntity.setId(followingRepository.findByFollowerAndFollowee(followingDTO.getFollower(),
			followingDTO.getFollowee()).getId());
		followingRepository.save(followingEntity);
	}

	@Override
	public boolean isFollowing(String followerUuid, String followedUuid) {
		return followingRepository.existsByFollowerAndFollowee(followerUuid, followedUuid);
	}

	@Override
	public long countFollowers(String followedUuid) {
		return followingRepository.countByFollowee(followedUuid);
	}

	@Override
	public long countFollowings(String followerUuid) {
		return followingRepository.countByFollower(followerUuid);
	}

	@Override
	public List<String> getFollowers(String followedUuid) {
		return List.of(followingRepository.findByFollowee(followedUuid).stream()
			.map(FollowingEntity::getFollower)
			.toArray(String[]::new));
	}

	@Override
	public List<String> getFollowings(String followerUuid) {
		return List.of(followingRepository.findByFollower(followerUuid).stream()
			.map(FollowingEntity::getFollowee)
			.toArray(String[]::new));
	}

	@Override
	public FollowingDTO getFollowingObject(String follower, String followee) {
		return JpaFollowingDTOEntityMapper.toDTO(followingRepository.findByFollowerAndFollowee(follower, followee));
	}

}
