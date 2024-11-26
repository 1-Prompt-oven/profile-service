package com.promptoven.profileservice.adaptor.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileUpdateRequestMapper;
import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateRequestVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileResponseVO;
import com.promptoven.profileservice.application.port.in.usecase.FollowingUsecase;
import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProfileRestController {

	private final ProfileCommonUsecase profileUseCase;
	private final FollowingUsecase followingUsecase;

	@PostMapping("/member/profile/follow/{nickname}")
	public ResponseEntity<Void> follow(
		@PathVariable String nickname,
		@RequestBody String followerId) {
		followingUsecase.follow(nickname, followerId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/member/profile/unfollow/{nickname}")
	public ResponseEntity<Void> unfollow(
		@PathVariable String nickname,
		@RequestBody String followerId) {
		followingUsecase.unfollow(nickname, followerId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/member/profile")
	public ResponseEntity<Void> updateProfile(
		@RequestBody ProfileUpdateRequestVO profileUpdateRequestVO) {
		profileUseCase.update(ProfileUpdateRequestMapper.toDTO(profileUpdateRequestVO));
		return ResponseEntity.ok().build();
	}

	@GetMapping("/profile/{nickname}")
	public ResponseEntity<ProfileResponseVO> getProfile(@PathVariable String nickname) {
		return ResponseEntity.ok(ProfileResponseVO.fromDTO(profileUseCase.getProfile(nickname)));
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

	@GetMapping("/profile/nickname/{nickname}")
	public ResponseEntity<ProfileResponseVO> getProfileByNickname(@PathVariable String nickname) {
		ProfileDTO profileDTO = profileUseCase.getProfile(nickname);
		ProfileResponseVO profileResponseVO = ProfileResponseVO.fromDTO(profileDTO);

		if (profileResponseVO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(profileResponseVO);
	}

	@GetMapping("/profile/uuid/{memberUUID}")
	public ResponseEntity<ProfileResponseVO> getProfileByUUID(@PathVariable String memberUUID) {
		ProfileDTO profileDTO = profileUseCase.getProfileByMemberUUID(memberUUID);
		ProfileResponseVO profileResponseVO = ProfileResponseVO.fromDTO(profileDTO);

		if (profileResponseVO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(profileResponseVO);
	}

	@GetMapping("/member/{memberUUID}/profile-info")
	public ResponseEntity<MemberProfileVO> getMemberProfileInfo(@PathVariable String memberUUID) {
		ProfileDTO profileDTO = profileUseCase.getProfileByMemberUUID(memberUUID);
		MemberProfileVO memberProfileVO = MemberProfileVO.fromDTO(profileDTO);

		if (memberProfileVO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(memberProfileVO);
	}

	// todo: request param: memberUUID, response: memberNickname + profileImageUrl
}
