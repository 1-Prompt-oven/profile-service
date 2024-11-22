package com.promptoven.profileservice.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowListModelDTO {

	private String memberUUID;

	private List<ProfileShortModelDTO> follows;
}
