package com.promptoven.profileservice.adaptor.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileVO;
import com.promptoven.profileservice.application.in.dto.ProfileDTO;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProfileManageRestController {

	private final ProfileUseCase profileUseCase;

	@GetMapping("/profile/{nickname}/followers")
	public List<ProfileVO> getFollowers(@PathVariable String nickname) {
		List<ProfileVO> collect = profileUseCase.getFollowers(nickname)
			.stream()
			.map((Object profileDTO) -> ProfileVO.fromDTO((ProfileDTO)profileDTO))
			.collect(Collectors.toList());
		return collect;
	}

	@GetMapping("/profile/{nickname}/following")
	public List<ProfileVO> getFollowing(@PathVariable String nickname) {
		return profileUseCase.getFollowing(nickname).stream().map((Object profileDTO) -> ProfileVO.fromDTO(
			(ProfileDTO)profileDTO)).collect(Collectors.toList());
	}
}
