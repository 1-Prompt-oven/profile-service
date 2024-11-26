package com.promptoven.profileservice.application.port.out.call;

import java.util.List;

import com.promptoven.profileservice.application.service.dto.FollowingDTO;

public interface FollowingPersistence {

	void follow(FollowingDTO followingDTO);

	void unfollow(FollowingDTO followingDTO);

	boolean isFollowing(String followerUuid, String followedUuid);

	long countFollowers(String followedUuid);

	long countFollowings(String followerUuid);

	List<String> getFollowers(String followedUuid);

	List<String> getFollowings(String followerUuid);
}
