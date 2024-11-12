package com.promptoven.profileservice.adaptor.infrastructure.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberBannedEvent {
    private String memberUUID;
    private String reason;
} 