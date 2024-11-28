package com.promptoven.profileservice.application.port.in.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemberBanEvent {

	private String memberUUID;
}
