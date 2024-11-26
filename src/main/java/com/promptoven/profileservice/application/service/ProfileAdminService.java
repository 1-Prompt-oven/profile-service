package com.promptoven.profileservice.application.service;

import com.promptoven.profileservice.application.port.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.port.in.dto.event.SettlementFirstCreateEvent;
import com.promptoven.profileservice.application.port.in.usecase.ProfileAdminUsecase;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

public class ProfileAdminService implements ProfileAdminUsecase {

	@Override
	public void withdraw(MemberWithdrawEvent event) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.withdraw(profile)));
	}

	@Override
	public void ban(MemberBanEvent event) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.ban(profile)));
	}

	@Override
	public void unban(MemberUnbanEvent event) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.unban(profile)));
	}

	@Override
	public void updateNickname(MemberNicknameUpdateEvent event) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.updateNickname(profile, nickname)));
	}

	@Override
	public void createProfile(MemberRegisterEvent event) {
		ProfileModelDTO profileModelDTO = ProfileModelDTO.builder()
			.memberUUID(event.getMemberUUID())
			.nickname(event.getNickname())
			.build();
		// Profile profile = Profile.CreateProfile(profileModelDTO);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(profile));

	}

	@Override
	public void promoteToCreator(SettlementFirstCreateEvent event) {

	}
}
