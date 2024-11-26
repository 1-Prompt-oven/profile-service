package com.promptoven.profileservice.application.service;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.dto.event.MemberBanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberNicknameUpdateEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberRegisterEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberUnbanEvent;
import com.promptoven.profileservice.application.port.in.dto.event.MemberWithdrawEvent;
import com.promptoven.profileservice.application.port.in.dto.event.SettlementFirstCreateEvent;
import com.promptoven.profileservice.application.port.in.usecase.ProfileAdminUsecase;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileDomainDTOMapper;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileAdminService implements ProfileAdminUsecase {

	private final ProfilePersistence profilePersistence;
	private final ProfileDomainDTOMapper profileDomainDTOMapper;

	@Override
	public void withdraw(MemberWithdrawEvent event) {
		ProfileDTO profileDTO = profilePersistence.read(event.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		profilePersistence.update(profileDomainDTOMapper.toDTO(Profile.acceptWithdraw(profile)));
	}

	@Override
	public void ban(MemberBanEvent event) {
		ProfileDTO profileDTO = profilePersistence.read(event.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		profilePersistence.update(profileDomainDTOMapper.toDTO(Profile.banProfile(profile)));
	}

	@Override
	public void unban(MemberUnbanEvent event) {
		ProfileDTO profileDTO = profilePersistence.read(event.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		profilePersistence.update(profileDomainDTOMapper.toDTO(Profile.unban(profile)));
	}

	@Override
	public void updateNickname(MemberNicknameUpdateEvent event) {
		ProfileDTO profileDTO = profilePersistence.read(event.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		profilePersistence.update(profileDomainDTOMapper.toDTO(Profile.updateNickname(profile, event.getNickname())));
	}

	@Override
	public void createProfile(MemberRegisterEvent event) {
		ProfileModelDTO profileModelDTO = ProfileModelDTO.builder()
			.memberUUID(event.getMemberUUID())
			.nickname(event.getNickname())
			.build();
		Profile profile = Profile.createProfile(profileModelDTO);
		profilePersistence.create(profileDomainDTOMapper.toDTO(profile));

	}

	@Override
	public void promoteToCreator(SettlementFirstCreateEvent event) {
		ProfileDTO profileDTO = profilePersistence.read(event.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		profilePersistence.update(profileDomainDTOMapper.toDTO(Profile.promotedToCreator(profile)));

	}
}
