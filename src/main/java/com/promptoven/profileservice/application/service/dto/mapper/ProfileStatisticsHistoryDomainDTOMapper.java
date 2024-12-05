package com.promptoven.profileservice.application.service.dto.mapper;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;
import com.promptoven.profileservice.domain.ProfileStatisticsHistory;

@Component
public class ProfileStatisticsHistoryDomainDTOMapper
	implements DomainDTOMapper<ProfileStatisticsHistory, ProfileStatisticsHistoryDTO> {

	@Override
	public ProfileStatisticsHistory toDomain(ProfileStatisticsHistoryDTO dto) {
		return ProfileStatisticsHistory.builder()
			.recordedAt(dto.getTargetDate())
			.memberUUID(dto.getMemberUUID())
			.sales(dto.getSales())
			.rank(dto.getRank())
			.viewer(dto.getViewer())
			.follower(dto.getFollower())
			.build();
	}

	@Override
	public ProfileStatisticsHistoryDTO toDTO(ProfileStatisticsHistory domain) {
		return ProfileStatisticsHistoryDTO.builder()
			.targetDate(domain.getRecordedAt())
			.memberUUID(domain.getMemberUUID())
			.sales(domain.getSales())
			.rank(domain.getRank())
			.viewer(domain.getViewer())
			.follower(domain.getFollower())
			.build();
	}
}
