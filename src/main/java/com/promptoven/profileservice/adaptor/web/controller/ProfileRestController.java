package com.promptoven.profileservice.adaptor.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileCountVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileVO;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProfileRestController {

	private final ProfileUseCase profileUseCase;

	@PostMapping("/member/profile/follow/{nickname}")
	public ResponseEntity<Void> follow(
			@PathVariable String nickname,
			@RequestBody String followerId) {
		profileUseCase.follow(nickname, followerId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/member/profile/unfollow/{nickname}")
	public ResponseEntity<Void> unfollow(
			@PathVariable String nickname,
			@RequestBody String followerId) {
		profileUseCase.unfollow(nickname, followerId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/member/profile")
	public ResponseEntity<Void> updateProfile(
			@RequestBody ProfileUpdateVO profileUpdateVO,
			@RequestBody String userId) {
		profileUseCase.updateProfile(profileUpdateVO.toDTO());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/profile/{nickname}")
	public ResponseEntity<ProfileVO> getProfile(@PathVariable String nickname) {
		return ResponseEntity.ok(ProfileVO.fromDTO(profileUseCase.getProfile(nickname)));
	}

	@GetMapping("/profile/{nickname}/count")
	public ResponseEntity<ProfileCountVO> getProfileCount(@PathVariable String nickname) {
		return ResponseEntity.ok(ProfileCountVO.fromDTO(profileUseCase.getProfileCount(nickname)));
	}

	@PostMapping("/profile/{nickname}/alarm/all")
	public ResponseEntity<Void> alarmAll(@PathVariable String nickname) {
		profileUseCase.alarm(nickname);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/profile/{nickname}/alarm/{alarmId}")
	public ResponseEntity<Void> alarmSpecific(
			@PathVariable String nickname,
			@PathVariable String alarmId) {
		profileUseCase.alarm(nickname, alarmId);
		return ResponseEntity.ok().build();
	}
}
