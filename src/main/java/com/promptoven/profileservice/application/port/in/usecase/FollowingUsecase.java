package com.promptoven.profileservice.application.port.in.usecase;

import java.util.List;

import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

public interface FollowingUsecase {

	void follow(String follower, String followee);

	void unfollow(String follower, String followee);

	boolean isFollowing(String follower, String followee);

	List<ProfileShortDTO> getFollowers(String followee);

	List<ProfileShortDTO> getFollowing(String follower);
}
