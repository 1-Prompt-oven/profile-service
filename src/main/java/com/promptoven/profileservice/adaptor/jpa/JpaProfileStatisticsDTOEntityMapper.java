package com.promptoven.profileservice.adaptor.jpa;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsEntity;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;

class JpaProfileStatisticsDTOEntityMapper {

	static ProfileStatisticsDTO toDTO(ProfileStatisticsEntity entity) {
		return ProfileStatisticsDTO.builder()
			.memberUUID(entity.getMemberUUID())
			.rank(entity.getRank())
			.rating(entity.getRating())
			.sales(entity.getSales())
			.viewer(entity.getViewer())
			.build();
	}

	static ProfileStatisticsEntity toEntity(ProfileStatisticsDTO dto) {
		return ProfileStatisticsEntity.builder()
			.memberUUID(dto.getMemberUUID())
			.rank(dto.getRank())
			.rating(dto.getRating())
			.sales(dto.getSales())
			.viewer(dto.getViewer())
			.build();
	}
}
