package com.promptoven.profileservice.application.port.in.dto.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberWithdrawEvent {

	private final String memberUUID;
}
