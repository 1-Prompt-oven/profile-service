package com.promptoven.profileservice.adaptor.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.in.dto.event.SettlementFirstCreateEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventSubscriberByKafka {

	// private final ProfileUseCase profileUseCase;

	@KafkaListener(topics = "${settlement-first-create-event}", containerFactory = "settlementFirstCreateListenerFactory")
	public void settlementFirstCreateEvent(SettlementFirstCreateEvent settlementFirstCreateEvent) {
		log.info("Received settlement first create event: {}", settlementFirstCreateEvent);
	}

	@KafkaListener(topics = "${member-ban-event}", containerFactory = "memberBanListenerFactory")
	public void memberBanEvent(MemberBanEvent memberBanEvent) {
		log.info("Received member ban event: {}", memberBanEvent);
	}

	@KafkaListener(topics = "${member-unban-event}", containerFactory = "memberUnbanListenerFactory")
	public void memberUnbanEvent(MemberUnbanEvent memberUnbanEvent) {
		log.info("Received member unban event: {}", memberUnbanEvent);
	}

	@KafkaListener(topics = "${member-nickname-update-event}", containerFactory = "memberNicknameUpdateListenerFactory")
	public void memberNicknameUpdateEvent(MemberNicknameUpdateEvent memberNicknameUpdateEvent) {
		log.info("Received member nickname update event: {}", memberNicknameUpdateEvent);
	}

	@KafkaListener(topics = "${member-register-event}", containerFactory = "memberRegisterListenerFactory")
	public void memberRegisterEvent(MemberRegisterEvent memberRegisterEvent) {
		log.info("Received member register event: {}", memberRegisterEvent);
	}

	@KafkaListener(topics = "${member-withdraw-event}", containerFactory = "memberWithdrawListenerFactory")
	public void memberWithdrawEvent(MemberWithdrawEvent memberWithdrawEvent) {
		log.info("Received member withdraw event: {}", memberWithdrawEvent);
	}

} 