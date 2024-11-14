package com.promptoven.profileservice.domain;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Following {

	private String follower;
	private String followee;
	private LocalDateTime FollowDate;
	@Nullable
	private LocalDateTime UnfollowDate;

	public static Following CreateFollowing(String follower, String followee) {
		return Following.builder()
			.follower(follower)
			.followee(followee)
			.FollowDate(LocalDateTime.now())
			.build();
	}

	public static Following Unfollow(Following oldFollowing) {
		return Following.builder()
			.follower(oldFollowing.getFollower())
			.followee(oldFollowing.getFollowee())
			.FollowDate(oldFollowing.getFollowDate())
			.UnfollowDate(LocalDateTime.now())
			.build();
	}
}
