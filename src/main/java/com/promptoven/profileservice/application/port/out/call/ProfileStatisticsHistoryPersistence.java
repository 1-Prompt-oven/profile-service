package com.promptoven.profileservice.application.port.out.call;

import java.time.LocalDate;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

public interface ProfileStatisticsHistoryPersistence {

	void record(ProfileStatisticsHistoryDTO profileStatisticsHistoryDTO);

	ProfileStatisticsHistoryDTO get(LocalDate targetDate, String targetUUID);
}
