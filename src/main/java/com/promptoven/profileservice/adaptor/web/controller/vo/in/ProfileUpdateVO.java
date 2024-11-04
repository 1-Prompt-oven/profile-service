package com.promptoven.profileservice.adaptor.web.controller.vo.in;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateVO {

	public ProfileDTO toDTO() {
		return ProfileDTO.builder().build();
	}
}
