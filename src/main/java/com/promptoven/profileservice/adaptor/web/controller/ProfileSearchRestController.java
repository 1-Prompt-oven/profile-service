package com.promptoven.profileservice.adaptor.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.adaptor.web.util.BaseResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/profile")
@RequiredArgsConstructor
public class ProfileSearchRestController {

	private final ProfileCommonUsecase profileCommonUsecase;

	@GetMapping("/{query}")
	public BaseResponse<Void> searchProfile(String query) {
		log.info("Searching profile by query: {}", query);
		profileCommonUsecase.search(query);
		return new BaseResponse<>();
	}
}
