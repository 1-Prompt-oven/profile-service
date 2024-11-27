package com.promptoven.profileservice.adaptor.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promptoven.profileservice.adaptor.jpa.entity.FollowingEntity;

public interface FollowingRepository extends JpaRepository<FollowingEntity, Long> {

	@Query("SELECT f FROM FollowingEntity f WHERE f.follower = :follower AND f.UnfollowDate IS NULL")
	List<FollowingEntity> findByFollower(String follower);

	@Query("SELECT f FROM FollowingEntity f WHERE f.followee = :followee AND f.UnfollowDate IS NULL")
	List<FollowingEntity> findByFollowee(String followee);

	@Query("SELECT f FROM FollowingEntity f WHERE f.follower = :follower AND f.followee = :followee AND f.UnfollowDate IS NULL")
	FollowingEntity findByFollowerAndFollowee(String follower, String followee);

	@Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FollowingEntity f WHERE f.follower = :follower AND f.followee = :followee AND f.UnfollowDate IS NULL")
	boolean existsByFollowerAndFollowee(String follower, String followee);

	@Query("SELECT COUNT(f) FROM FollowingEntity f WHERE f.follower = :follower AND f.UnfollowDate IS NULL")
	long countByFollower(String follower);

	@Query("SELECT COUNT(f) FROM FollowingEntity f WHERE f.followee = :followee AND f.UnfollowDate IS NULL")
	long countByFollowee(String followee);
}
