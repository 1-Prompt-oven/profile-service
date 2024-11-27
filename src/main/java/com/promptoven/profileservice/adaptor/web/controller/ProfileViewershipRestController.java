package com.promptoven.profileservice.adaptor.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.util.BaseResponse;
import com.promptoven.profileservice.application.port.in.usecase.ProfileViewershipUsecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/profile/viewership")
@RequiredArgsConstructor
public class ProfileViewershipRestController {

	private final ProfileViewershipUsecase profileViewershipUsecase;

	@PostMapping("/nickname/{nickname}")
	public BaseResponse<Void> addViewer(@PathVariable String nickname) {
		profileViewershipUsecase.addViewCountByNickname(nickname);
		return new BaseResponse<>();
	}

	@PostMapping("/id/{profileId}")
	public BaseResponse<Void> addViewerById(@PathVariable String profileId) {
		profileViewershipUsecase.addViewCount(profileId);
		return new BaseResponse<>();
	}

	@PostMapping("/test/{profileId}")
	public BaseResponse<Void> test(@PathVariable String profileId) {
		profileViewershipUsecase.applyViewCounts(profileId);
		return new BaseResponse<>();
	}
}
