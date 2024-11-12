package com.promptoven.profileservice.adaptor.infrastructure.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreatedEvent {
    private String memberUUID;
    private String nickname;
    private boolean isCreator;
} 