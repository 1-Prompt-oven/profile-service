package com.promptoven.profileservice.application.out.call;

import java.util.List;

import com.promptoven.profileservice.domain.Following;

public interface FollowingPersistence {

	void save(Following following);

	void unfollow(String nickname, String followerId);

	List<String> getFollowers(String nickname);

	List<String> getFollowing(String nickname);


}
