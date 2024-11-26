package com.promptoven.profileservice.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberNicknameUpdateRequestEvent {
	private String memberUuid;
	private String nickname;
}
