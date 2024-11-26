package com.promptoven.profileservice.application.port.in.usecase;

import java.util.List;

import com.promptoven.profileservice.application.port.in.dto.FollowRequestDTO;
import com.promptoven.profileservice.application.port.in.dto.UnfollowRequestDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

public interface FollowingUsecase {

	void follow(FollowRequestDTO followRequestDTO);

	void unfollow(UnfollowRequestDTO unfollowRequestDTO);

	boolean isFollowing(String follower, String followee);

	List<ProfileShortDTO> getFollowers(String followee);

	List<ProfileShortDTO> getFollowing(String follower);
}
