package com.promptoven.profileservice.adaptor.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.promptoven.profileservice.application.port.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.port.in.dto.event.SettlementFirstCreateEvent;
import com.promptoven.profileservice.application.port.in.usecase.ProfileAdminUsecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventSubscriberByKafka {

	private final ProfileAdminUsecase profileAdminUsecase;

	@KafkaListener(topics = "${settlement-first-create-event}", containerFactory = "settlementFirstCreateListenerFactory")
	public void settlementFirstCreateEvent(SettlementFirstCreateEvent settlementFirstCreateEvent) {
		profileAdminUsecase.promoteToCreator(settlementFirstCreateEvent);
	}

	@KafkaListener(topics = "${member-ban-event}", containerFactory = "memberBanListenerFactory")
	public void memberBanEvent(MemberBanEvent memberBanEvent) {
		profileAdminUsecase.ban(memberBanEvent);
	}

	@KafkaListener(topics = "${member-unban-event}", containerFactory = "memberUnbanListenerFactory")
	public void memberUnbanEvent(MemberUnbanEvent memberUnbanEvent) {
		profileAdminUsecase.unban(memberUnbanEvent);
	}

	@KafkaListener(topics = "${member-nickname-update-event}", containerFactory = "memberNicknameUpdateListenerFactory")
	public void memberNicknameUpdateEvent(MemberNicknameUpdateEvent memberNicknameUpdateEvent) {
		profileAdminUsecase.updateNickname(memberNicknameUpdateEvent);
	}

	@KafkaListener(topics = "${member-register-event}", containerFactory = "memberRegisterListenerFactory")
	public void memberRegisterEvent(MemberRegisterEvent memberRegisterEvent) {
		profileAdminUsecase.createProfile(memberRegisterEvent);
	}

	@KafkaListener(topics = "${member-withdraw-event}", containerFactory = "memberWithdrawListenerFactory")
	public void memberWithdrawEvent(MemberWithdrawEvent memberWithdrawEvent) {
		profileAdminUsecase.withdraw(memberWithdrawEvent);
	}

} 