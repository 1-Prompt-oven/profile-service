package com.promptoven.profileservice.application.in.dto.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberWithdrawEvent {

	private final String memberUUID;
}
