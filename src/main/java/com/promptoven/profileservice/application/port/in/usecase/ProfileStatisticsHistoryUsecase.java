package com.promptoven.profileservice.application.port.in.usecase;

import java.util.List;

import com.promptoven.profileservice.application.port.in.dto.ProfileStatisticsHistoryRequestDTO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

public interface ProfileStatisticsHistoryUsecase {

	List<ProfileStatisticsHistoryDTO> getProfileStatisticsHistory(
		ProfileStatisticsHistoryRequestDTO profileStatisticsHistoryRequestDTO);
}
