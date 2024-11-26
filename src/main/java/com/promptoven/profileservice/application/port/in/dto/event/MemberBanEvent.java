package com.promptoven.profileservice.application.port.in.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberBanEvent {

	private final String memberUUID;
}
