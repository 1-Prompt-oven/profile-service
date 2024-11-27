package com.promptoven.profileservice.adaptor.web.controller;

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
import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileShortResponseVO;
import com.promptoven.profileservice.adaptor.web.util.BaseResponse;
import com.promptoven.profileservice.adaptor.web.util.BaseResponseStatus;
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
	public BaseResponse<Void> follow(
		@PathVariable String nickname,
		@RequestBody FollowRequestVO followRequestVO) {
		followingUsecase.follow(FollowingRequestMapper.toFollowRequestDTO(followRequestVO, nickname));
		return new BaseResponse<>();
	}

	@PostMapping("/member/profile/unfollow/{nickname}")
	public BaseResponse<Void> unfollow(
		@PathVariable String nickname,
		@RequestBody UnfollowRequestVO unfollowRequestVO) {
		followingUsecase.unfollow(FollowingRequestMapper.toUnfollowRequestDTO(unfollowRequestVO, nickname));
		return new BaseResponse<>();
	}

	@PutMapping("/member/profile")
	public BaseResponse<Void> updateProfile(
		@RequestBody ProfileUpdateRequestVO profileUpdateRequestVO) {
		profileUseCase.update(ProfileUpdateRequestMapper.toDTO(profileUpdateRequestVO));
		return new BaseResponse<>();
	}

	@GetMapping("/profile/nickname/{nickname}")
	public BaseResponse<ProfileResponseVO> getProfileByNickname(@PathVariable String nickname) {
		ProfileDTO profileDTO = profileUseCase.getByNickname(nickname);
		ProfileResponseVO profileResponseVO = ProfileResponseMapper.toVO(profileDTO);

		if (profileResponseVO == null) {
			return new BaseResponse<>(BaseResponseStatus.NOT_FOUND_DATA);
		}

		return new BaseResponse<>(profileResponseVO);
	}

	@GetMapping("/profile/uuid/{memberUUID}")
	public BaseResponse<ProfileResponseVO> getProfileByUUID(@PathVariable String memberUUID) {
		ProfileDTO profileDTO = profileUseCase.get(memberUUID);
		ProfileResponseVO profileResponseVO = ProfileResponseMapper.toVO(profileDTO);

		if (profileResponseVO == null) {
			return new BaseResponse<>(BaseResponseStatus.NOT_FOUND_DATA);
		}

		return new BaseResponse<>(profileResponseVO);
	}

	@GetMapping("/profile/nickname/{nickname}/following")
	public BaseResponse<ProfileResponseVO> getFollowingByNickname(@PathVariable String nickname) {
		followingUsecase.getFollowing(nickname);
		return new BaseResponse<>(null);
	}

	@GetMapping("/profile/nickname/{nickname}/follower")
	public BaseResponse<ProfileResponseVO> getFollowerByNickname(@PathVariable String nickname) {
		followingUsecase.getFollowers(nickname);
		return new BaseResponse<>(null);
	}

	@GetMapping("/profile/uuid/{memberUUID}/short")
	public BaseResponse<ProfileShortResponseVO> getShortProfileByUUID(@PathVariable String memberUUID) {
		ProfileShortResponseVO profileShortResponseVO = ProfileResponseMapper.toShortVO(
			profileUseCase.getShort(memberUUID));

		if (null == profileShortResponseVO) {
			return new BaseResponse<>(BaseResponseStatus.NOT_FOUND_DATA);
		}

		return new BaseResponse<>(profileShortResponseVO);
	}

	@GetMapping("/profile/nickname/{nickname}/short")
	public BaseResponse<ProfileShortResponseVO> getShortProfileByNickname(@PathVariable String nickname) {
		ProfileShortResponseVO profileShortResponseVO = ProfileResponseMapper.toShortVO(
			profileUseCase.getShortByNickname(nickname));

		if (null == profileShortResponseVO) {
			return new BaseResponse<>(BaseResponseStatus.NOT_FOUND_DATA);
		}

		return new BaseResponse<>(profileShortResponseVO);
	}
}
