package com.promptoven.profileservice.application.port.out.call;

public interface ProfileViewershipMemory {

	void addViewCount(String profileUUID);
	
	Long getAndResetViewCount(String profileUUID);
}
