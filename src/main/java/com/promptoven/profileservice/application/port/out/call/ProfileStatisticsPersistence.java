package com.promptoven.profileservice.application.port.out.call;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;

public interface ProfileStatisticsPersistence {

	void addProfileViewCount(String profileUUID, Long count);

	void create(ProfileStatisticsDTO profileStatisticsDTO);

}
