package com.promptoven.profileservice.application.port.in.usecase;

import com.promptoven.profileservice.application.port.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.port.in.dto.event.SettlementFirstCreateEvent;

public interface ProfileAdminUsecase {

	void withdraw(MemberWithdrawEvent event);

	void ban(MemberBanEvent event);

	void unban(MemberUnbanEvent event);

	void updateNickname(MemberNicknameUpdateEvent event);

	void createProfile(MemberRegisterEvent event);

	void promoteToCreator(SettlementFirstCreateEvent event);
}
