package com.promptoven.profileservice.application.port.out.call;

public interface ProfileStatisticsPersistence {

	void addProfileViewCount(String profileUUID, Long count);

}
