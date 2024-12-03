package com.promptoven.profileservice.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ProfilePictureResponseDTO {
	private final String memberUUID;
	private final String Picture;
}
