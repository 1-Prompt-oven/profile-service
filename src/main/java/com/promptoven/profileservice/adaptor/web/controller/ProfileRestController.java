package com.promptoven.profileservice.adaptor.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.mapper.FollowingRequestMapper;
import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileResponseMapper;
import com.promptoven.profileservice.adaptor.web.controller.mapper.ProfileUpdateRequestMapper;
import com.promptoven.profileservice.adaptor.web.controller.vo.in.FollowRequestVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateRequestVO;
import com.promptoven.profileservice.adaptor.web.controller.vo.in.UnfollowRequestVO;
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
		@RequestBody FollowRequestVO followRequestVO) {
		followingUsecase.follow(FollowingRequestMapper.toFollowRequestDTO(followRequestVO, nickname));
		return ResponseEntity.ok().build();
	}

	@PostMapping("/member/profile/unfollow/{nickname}")
	public ResponseEntity<Void> unfollow(
		@PathVariable String nickname,
		@RequestBody UnfollowRequestVO unfollowRequestVO) {
		followingUsecase.unfollow(FollowingRequestMapper.toUnfollowRequestDTO(unfollowRequestVO, nickname));
		return ResponseEntity.ok().build();
	}

	@PutMapping("/member/profile")
	public ResponseEntity<Void> updateProfile(
		@RequestBody ProfileUpdateRequestVO profileUpdateRequestVO) {
		profileUseCase.update(ProfileUpdateRequestMapper.toDTO(profileUpdateRequestVO));
		return ResponseEntity.ok().build();
	}

	@GetMapping("/profile/nickname/{nickname}")
	public ResponseEntity<ProfileResponseVO> getProfileByNickname(@PathVariable String nickname) {
		ProfileDTO profileDTO = profileUseCase.getByNickname(nickname);
		ProfileResponseVO profileResponseVO = ProfileResponseMapper.toVO(profileDTO);

		if (profileResponseVO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(profileResponseVO);
	}

	@GetMapping("/profile/uuid/{memberUUID}")
	public ResponseEntity<ProfileResponseVO> getProfileByUUID(@PathVariable String memberUUID) {
		ProfileDTO profileDTO = profileUseCase.get(memberUUID);
		ProfileResponseVO profileResponseVO = ProfileResponseMapper.toVO(profileDTO);

		if (profileResponseVO == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(profileResponseVO);
	}

	@GetMapping("/profile/nickname/{nickname}/following")
	public ResponseEntity<ProfileResponseVO> getFollowingByNickname(@PathVariable String nickname) {
		followingUsecase.getFollowing(nickname);

		return ResponseEntity.ok(null);
	}

	@GetMapping("/profile/nickname/{nickname}/follower")
	public ResponseEntity<ProfileResponseVO> getFollowerByNickname(@PathVariable String nickname) {
		followingUsecase.getFollowers(nickname);

		return ResponseEntity.ok(null);
	}
}
