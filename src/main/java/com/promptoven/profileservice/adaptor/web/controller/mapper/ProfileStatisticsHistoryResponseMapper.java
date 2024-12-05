package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileStatisticsHistoryResponseVO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

public class ProfileStatisticsHistoryResponseMapper {
	public static ProfileStatisticsHistoryResponseVO toVO(ProfileStatisticsHistoryDTO dto) {
		return ProfileStatisticsHistoryResponseVO.builder()
			.targetDate(dto.getTargetDate())
			.memberUUID(dto.getMemberUUID())
			.viewer(dto.getViewer())
			.sales(dto.getSales())
			.rank(dto.getRank())
			.rating(dto.getRating())
			.follower(dto.getFollower())
			.build();
	}
}