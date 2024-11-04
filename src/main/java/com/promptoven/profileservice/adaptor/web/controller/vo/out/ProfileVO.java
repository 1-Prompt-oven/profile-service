package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ProfileVO {

	public static ProfileVO fromDTO(ProfileDTO profileDTO) {
		return ProfileVO.builder().build();
	}
}
