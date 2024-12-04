package com.promptoven.profileservice.adaptor.web.webclient;

import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;

class DtoVoMapper {

	static final SellerStatisticDTO toDTO(SellerStatisticsVO sellerStatisticsVO) {
		return SellerStatisticDTO.builder()
			.memberUUID(sellerStatisticsVO.getMemberUuid())
			.rank(sellerStatisticsVO.getRanking())
			.sales(sellerStatisticsVO.getSellsCount())
			.build();
	}
}
