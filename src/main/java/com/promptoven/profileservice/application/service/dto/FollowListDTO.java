package com.promptoven.profileservice.application.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowListDTO {

	private String memberUUID;

	private List<ProfileShortDTO> follows;
}
