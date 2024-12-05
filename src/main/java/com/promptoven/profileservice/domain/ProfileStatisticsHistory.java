package com.promptoven.profileservice.domain;

import java.time.LocalDate;

import com.promptoven.profileservice.domain.dto.ProfileStatisticsModelDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ProfileStatisticsHistory {

	private LocalDate recordedAt;
	private String memberUUID;
	private Long viewer;
	private Long sales;
	private Long rank;
	private Double rating;
	private Long follower;

	public static ProfileStatisticsHistory create(ProfileStatisticsModelDTO profileStatisticsModelDTO, Long follower) {
		return ProfileStatisticsHistory.builder()
			.recordedAt(LocalDate.now())
			.memberUUID(profileStatisticsModelDTO.getMemberUUID())
			.viewer(profileStatisticsModelDTO.getViewer())
			.sales(profileStatisticsModelDTO.getSales())
			.rank(profileStatisticsModelDTO.getRank())
			.rating(profileStatisticsModelDTO.getRating())
			.follower(follower)
			.build();
	}
}
