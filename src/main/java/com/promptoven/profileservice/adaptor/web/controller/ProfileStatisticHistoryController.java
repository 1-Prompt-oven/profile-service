package com.promptoven.profileservice.adaptor.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileStatisticsHistoryRequestMapper;
import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileStatisticsHistoryResponseMapper;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileStatisticsHistoryResponseVO;
import com.promptoven.profileservice.adaptor.web.util.BaseResponse;
import com.promptoven.profileservice.application.port.in.usecase.ProfileStatisticsHistoryUsecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/profile/history")
@RequiredArgsConstructor
public class ProfileStatisticHistoryController {

	private final ProfileStatisticsHistoryUsecase profileStatisticsHistoryUsecase;

	@GetMapping("/{memberUUID}/{beginDate}/{endDate}")
	public BaseResponse<List<ProfileStatisticsHistoryResponseVO>> getHistory(
		@PathVariable String memberUUID, @PathVariable LocalDate beginDate, @PathVariable LocalDate endDate) {
		List<ProfileStatisticsHistoryResponseVO> responseVOList = profileStatisticsHistoryUsecase.getProfileStatisticsHistory(
			ProfileStatisticsHistoryRequestMapper.toDTO(memberUUID, queryRange(beginDate, endDate))).stream().map(
			ProfileStatisticsHistoryResponseMapper::toVO).toList();
		return new BaseResponse<>(responseVOList);
	}

	Pair<LocalDate, LocalDate> queryRange(LocalDate begin, LocalDate end) {
		return Pair.of(begin, end);
	}
}
