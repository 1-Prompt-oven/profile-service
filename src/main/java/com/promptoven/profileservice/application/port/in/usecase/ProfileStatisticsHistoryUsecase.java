package com.promptoven.profileservice.application.port.in.usecase;

import java.time.LocalDate;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

public interface ProfileStatisticsHistoryUsecase {

	ProfileStatisticsHistoryDTO getProfileStatisticsHistory(String memberUUID, LocalDate targetDate);
}
