package com.promptoven.profileservice.domain;

import com.promptoven.profileservice.domain.dto.ProfileStatisticsModelDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ProfileStatistics {

	private String memberUUID;

	private Long viewer;

	private Long sales;

	private Long rank;

	private Double rating;

	public static ProfileStatistics create(ProfileStatisticsModelDTO profileStatisticsModelDTO) {
		return ProfileStatistics.builder()
			.memberUUID(profileStatisticsModelDTO.getMemberUUID())
			.viewer(profileStatisticsModelDTO.getViewer())
			.sales(profileStatisticsModelDTO.getSales())
			.rank(profileStatisticsModelDTO.getRank())
			.rating(profileStatisticsModelDTO.getRating())
			.build();
	}

	public static ProfileStatistics update(ProfileStatistics profileStatistics,
		ProfileStatisticsModelDTO profileStatisticsModelDTO) {
		return ProfileStatistics.builder()
			.memberUUID(profileStatisticsModelDTO.getMemberUUID())
			.viewer(profileStatisticsModelDTO.getViewer())
			.sales(profileStatisticsModelDTO.getSales())
			.rank(profileStatisticsModelDTO.getRank())
			.rating(profileStatisticsModelDTO.getRating())
			.build();
	}
}
