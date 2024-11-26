package com.promptoven.profileservice.application.port.in.usecase;

public interface ProfileViewershipUsecase {

	// In each profile view, the view count of the profile is increased by 1.
	// this adding value will cache on redis. and will apply later.
	void addViewCount(String profileId);

	// The view count of the profile in redis is applied to the profile.
	// The view count of the profile is reset to 0.
	void applyViewCounts();
}
