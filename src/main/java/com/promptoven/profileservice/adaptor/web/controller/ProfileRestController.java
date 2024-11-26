// package com.promptoven.profileservice.adaptor.web.controller;
//
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.promptoven.profileservice.adaptor.web.controller.vo.in.ProfileUpdateVO;
// import com.promptoven.profileservice.adaptor.web.controller.vo.out.MemberProfileVO;
// import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileCountVO;
// import com.promptoven.profileservice.adaptor.web.controller.vo.out.ProfileVO;
// import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;
// import com.promptoven.profileservice.application.service.dto.ProfileDTO;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
//
// @Slf4j
// @RestController
// @RequestMapping("/v1")
// @RequiredArgsConstructor
// public class ProfileRestController {
//
// 	private final ProfileUseCase profileUseCase;
//
// 	@PostMapping("/member/profile/follow/{nickname}")
// 	public ResponseEntity<Void> follow(
// 		@PathVariable String nickname,
// 		@RequestBody String followerId) {
// 		profileUseCase.follow(nickname, followerId);
// 		return ResponseEntity.ok().build();
// 	}
//
// 	@PostMapping("/member/profile/unfollow/{nickname}")
// 	public ResponseEntity<Void> unfollow(
// 		@PathVariable String nickname,
// 		@RequestBody String followerId) {
// 		profileUseCase.unfollow(nickname, followerId);
// 		return ResponseEntity.ok().build();
// 	}
//
// 	@PutMapping("/member/profile")
// 	public ResponseEntity<Void> updateProfile(
// 		@RequestBody ProfileUpdateVO profileUpdateVO,
// 		@RequestBody String userId) {
// 		profileUseCase.updateProfile(profileUpdateVO.toDTO());
// 		return ResponseEntity.ok().build();
// 	}
//
// 	@GetMapping("/profile/{nickname}")
// 	public ResponseEntity<ProfileVO> getProfile(@PathVariable String nickname) {
// 		return ResponseEntity.ok(ProfileVO.fromDTO(profileUseCase.getProfile(nickname)));
// 	}
//
// 	@GetMapping("/profile/{nickname}/count")
// 	public ResponseEntity<ProfileCountVO> getProfileCount(@PathVariable String nickname) {
// 		return ResponseEntity.ok(ProfileCountVO.fromDTO(profileUseCase.getProfileCount(nickname)));
// 	}
//
// 	@PostMapping("/profile/{nickname}/alarm/all")
// 	public ResponseEntity<Void> alarmAll(@PathVariable String nickname) {
// 		profileUseCase.alarm(nickname);
// 		return ResponseEntity.ok().build();
// 	}
//
// 	@PostMapping("/profile/{nickname}/alarm/{alarmId}")
// 	public ResponseEntity<Void> alarmSpecific(
// 		@PathVariable String nickname,
// 		@PathVariable String alarmId) {
// 		profileUseCase.alarm(nickname, alarmId);
// 		return ResponseEntity.ok().build();
// 	}
//
// 	@GetMapping("/profile/nickname/{nickname}")
// 	public ResponseEntity<ProfileVO> getProfileByNickname(@PathVariable String nickname) {
// 		ProfileDTO profileDTO = profileUseCase.getProfile(nickname);
// 		ProfileVO profileVO = ProfileVO.fromDTO(profileDTO);
//
// 		if (profileVO == null) {
// 			return ResponseEntity.notFound().build();
// 		}
//
// 		return ResponseEntity.ok(profileVO);
// 	}
//
// 	@GetMapping("/profile/uuid/{memberUUID}")
// 	public ResponseEntity<ProfileVO> getProfileByUUID(@PathVariable String memberUUID) {
// 		ProfileDTO profileDTO = profileUseCase.getProfileByMemberUUID(memberUUID);
// 		ProfileVO profileVO = ProfileVO.fromDTO(profileDTO);
//
// 		if (profileVO == null) {
// 			return ResponseEntity.notFound().build();
// 		}
//
// 		return ResponseEntity.ok(profileVO);
// 	}
//
// 	@GetMapping("/member/{memberUUID}/profile-info")
// 	public ResponseEntity<MemberProfileVO> getMemberProfileInfo(@PathVariable String memberUUID) {
// 		ProfileDTO profileDTO = profileUseCase.getProfileByMemberUUID(memberUUID);
// 		MemberProfileVO memberProfileVO = MemberProfileVO.fromDTO(profileDTO);
//
// 		if (memberProfileVO == null) {
// 			return ResponseEntity.notFound().build();
// 		}
//
// 		return ResponseEntity.ok(memberProfileVO);
// 	}
//
// 	// todo: request param: memberUUID, response: memberNickname + profileImageUrl
// }
