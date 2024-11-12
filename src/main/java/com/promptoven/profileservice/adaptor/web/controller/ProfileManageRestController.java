package com.promptoven.profileservice.adaptor.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ProfileVO>> getFollowers(@PathVariable String nickname) {
		List<ProfileVO> followers = profileUseCase.getFollowers(nickname)
			.stream()
			.map(profileDTO -> ProfileVO.fromDTO((ProfileDTO) profileDTO))
			.collect(Collectors.toList());
		return ResponseEntity.ok(followers);
	}

	@GetMapping("/profile/{nickname}/following")
	public ResponseEntity<List<ProfileVO>> getFollowing(@PathVariable String nickname) {
		List<ProfileVO> following = profileUseCase.getFollowing(nickname)
			.stream()
			.map(profileDTO -> ProfileVO.fromDTO((ProfileDTO) profileDTO))
			.collect(Collectors.toList());
		return ResponseEntity.ok(following);
	}

	@GetMapping("/admin/creators/top")
	public ResponseEntity<List<ProfileVO>> getTopCreators() {
		List<ProfileVO> topCreators = profileUseCase.getTopCreators()
			.stream()
			.map(profileDTO -> ProfileVO.fromDTO((ProfileDTO) profileDTO))
			.collect(Collectors.toList());
		return ResponseEntity.ok(topCreators);
	}
}
