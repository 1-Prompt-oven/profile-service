package com.promptoven.profileservice.application.out.call;

import java.util.List;

public interface FollowingPersistence {

	void follow(String profileId, String followerId);

	void unfollow(String nickname, String followerId);

	List<String> getFollowers(String nickname);

	List<String> getFollowing(String nickname);


}
