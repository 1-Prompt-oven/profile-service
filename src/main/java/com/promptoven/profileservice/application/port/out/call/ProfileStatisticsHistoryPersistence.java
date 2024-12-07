package com.promptoven.profileservice.application.port.out.call;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Pair;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

public interface ProfileStatisticsHistoryPersistence {

	void record(ProfileStatisticsHistoryDTO profileStatisticsHistoryDTO);

	List<ProfileStatisticsHistoryDTO> get(Pair<LocalDate, LocalDate> range, String targetUUID);
}
