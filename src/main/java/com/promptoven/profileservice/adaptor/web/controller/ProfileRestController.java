package com.promptoven.profileservice.adaptor.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileCountVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileVO;
import com.promptoven.profileservice.application.in.dto.ProfileDTO;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProfileRestController {

	private final ProfileUseCase profileUseCase;

	@PostMapping("/member/profile/follow")
	public void follow(@RequestBody String nickname, @RequestBody String followerId) {
		profileUseCase.follow(nickname, followerId);
	}

	@PostMapping("/member/profile/unfollow")
	public void unfollow(@RequestBody String nickname, @RequestBody String followerId) {
		profileUseCase.unfollow(nickname, followerId);
	}

	@PutMapping("/member/profile")
	public void updateProfile(@RequestBody ProfileUpdateVO profileUpdateVO) {
		profileUseCase.updateProfile(profileUpdateVO.toDTO());
	}

	@GetMapping("/profile/{nickname}")
	public ProfileVO getProfile(@PathVariable String nickname) {
		return ProfileVO.fromDTO(profileUseCase.getProfile(nickname));
	}



	@GetMapping("/profile/{nickname}/count")
	public ProfileCountVO getProfileCount(@PathVariable String nickname) {
		return ProfileCountVO.fromDTO(profileUseCase.getProfileCount(nickname));
	}

	@PostMapping("/profile/{nickname}/alarm/all")
	public void alarm(@PathVariable String nickname) {
		profileUseCase.alarm(nickname);
	}

	@PostMapping("/profile/{nickname}/alarm/{alarmId}")
	public void alarm(@PathVariable String nickname, @PathVariable String alarmId) {
		profileUseCase.alarm(nickname, alarmId);
	}


}
