package com.promptoven.profileservice.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberNicknameUpdateRequestEvent {
	private String memberUUID;
	private String nickname;
}
