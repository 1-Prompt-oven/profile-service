package com.promptoven.profileservice.application.port.in.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberUnbanEvent {

	private final String memberUUID;
}
