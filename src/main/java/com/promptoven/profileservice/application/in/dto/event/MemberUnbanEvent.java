package com.promptoven.profileservice.application.in.dto.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberUnbanEvent {

	private final String memberUUID;
}
