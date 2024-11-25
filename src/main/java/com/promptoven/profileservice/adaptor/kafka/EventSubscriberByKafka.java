package com.promptoven.profileservice.adaptor.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.in.dto.event.MemberBannedEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberRegisteredEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberWithdrawnEvent;
import com.promptoven.profileservice.application.in.usecase.ProfileUseCase;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

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
	@KafkaListener(topics = "${member-register-event}")
	public void handleMemberCreated(MemberRegisteredEvent event) {
		log.info("Received member created event: {}", event);
		ProfileModelDTO profileModelDTO = ProfileModelDTO.builder()
			.memberUUID(event.getMemberUUID())
			.nickname(event.getNickname())
			.build();
		profileUseCase.createProfile(profileModelDTO);
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