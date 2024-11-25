package com.promptoven.profileservice.application.in.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisteredEvent {
	private String memberUUID;
	private String nickname;
}