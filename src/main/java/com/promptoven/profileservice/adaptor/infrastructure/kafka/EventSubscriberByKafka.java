package com.promptoven.profileservice.adaptor.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.promptoven.profileservice.adaptor.infrastructure.kafka.event.MemberBannedEvent;
import com.promptoven.profileservice.adaptor.infrastructure.kafka.event.MemberCreatedEvent;
import com.promptoven.profileservice.adaptor.infrastructure.kafka.event.MemberWithdrawnEvent;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;
import com.promptoven.profileservice.domain.Profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventSubscriberByKafka {

    private final ProfileUseCase profileUseCase;
/*
@KafkaListener(topics = "member-created", containerFactory = "simpleKafkaListenerContainerFactory") : String Deserializer listener
@KafkaListener(topics = "member-created", containerFactory = "kafkaListenerContainerFactory") : Json Deserializer listener
* */
    @KafkaListener(topics = "member-created")
    public void handleMemberCreated(MemberCreatedEvent event) {
        log.info("Received member created event: {}", event);
        Profile profile = Profile.createProfile(
            event.getMemberUUID(),
            event.getNickname(),
            event.isCreator()
        );
        profileUseCase.createProfile(profile);
    }

    @KafkaListener(topics = "member-withdrawn")
    public void handleMemberWithdrawn(MemberWithdrawnEvent event) {
        log.info("Received member withdrawn event: {}", event);
        profileUseCase.withdrawProfile(event.getMemberUUID());
    }

    @KafkaListener(topics = "member-banned")
    public void handleMemberBanned(MemberBannedEvent event) {
        log.info("Received member banned event: {}", event);
        profileUseCase.banProfile(event.getMemberUUID(), event.getReason());
    }
} 