package com.promptoven.profileservice.application.service.dto.mapper;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;
import com.promptoven.profileservice.domain.ProfileStatistics;
import com.promptoven.profileservice.domain.dto.ProfileStatisticsModelDTO;

@Component
public class ProfileStatisticsDomainDTOMapper implements DomainDTOMapper<ProfileStatistics, ProfileStatisticsDTO> {

	@Override
	public ProfileStatisticsDTO toDTO(ProfileStatistics domain) {
		return ProfileStatisticsDTO.builder()
			.memberUUID(domain.getMemberUUID())
			.viewer(domain.getViewer())
			.sales(domain.getSales())
			.rank(domain.getRank())
			.rating(domain.getRating())
			.build();
	}

	@Override
	public ProfileStatistics toDomain(ProfileStatisticsDTO dto) {
		return ProfileStatistics.builder()
			.memberUUID(dto.getMemberUUID())
			.viewer(dto.getViewer())
			.sales(dto.getSales())
			.rank(dto.getRank())
			.rating(dto.getRating())
			.build();
	}

	public ProfileStatisticsModelDTO toModelDTO(ProfileStatisticsDTO dto) {
		return ProfileStatisticsModelDTO.builder()
			.memberUUID(dto.getMemberUUID())
			.viewer(dto.getViewer())
			.sales(dto.getSales())
			.rank(dto.getRank())
			.rating(dto.getRating())
			.build();
	}
}
