package com.promptoven.profileservice.adaptor.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileResponseMapper;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileSearchResponseVO;
import com.promptoven.profileservice.adaptor.web.util.BaseResponse;
import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/profile")
@RequiredArgsConstructor
public class ProfileSearchRestController {

	private final ProfileCommonUsecase profileCommonUsecase;

	@GetMapping("/{query}")
	public BaseResponse<List<ProfileSearchResponseVO>> searchProfile(String query) {
		log.info("Searching profile by query: {}", query);
		List<ProfileShortDTO> searchResults = profileCommonUsecase.search(query);
		log.info("Found {} profiles", searchResults.size());
		List<ProfileSearchResponseVO> profileSearchResponseVOs = searchResults.stream()
			.map(ProfileResponseMapper::toSearchVO)
			.collect(Collectors.toList());
		return new BaseResponse<>(profileSearchResponseVOs);
	}
}
