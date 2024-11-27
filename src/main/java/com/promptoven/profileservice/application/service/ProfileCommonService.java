package com.promptoven.profileservice.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.application.port.out.call.EventPublisher;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.port.out.dto.MemberNicknameUpdateRequestEvent;
import com.promptoven.profileservice.application.port.out.dto.MemberProfilePictureUpdateEvent;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileDomainDTOMapper;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileCommonService implements ProfileCommonUsecase {

	private final ProfilePersistence profilePersistence;
	private final ProfileDomainDTOMapper profileDomainDTOMapper;
	private final EventPublisher eventPublisher;

	@Value("${profile-nickname-update-request-event}")
	private String nicknameUpdateRequestTopic;
	@Value("${profile-picture-update-event}")
	private String profilePictureUpdateTopic;

	@Override
	public ProfileDTO get(String memberUUID) {
		return profilePersistence.read(memberUUID);
	}

	@Override
	public ProfileDTO getByNickname(String nickname) {
		return profilePersistence.readByNickname(nickname);
	}

	@Override
	public void update(ProfileUpdateRequestDTO profileUpdateRequestDTO) {
		ProfileDTO profileDTO = profilePersistence.read(profileUpdateRequestDTO.getMemberUUID());
		Profile profile = profileDomainDTOMapper.toDomain(profileDTO);
		ProfileModelDTO profileUpdateModelDTO = profileDomainDTOMapper.toUpdateModelDTO(profileUpdateRequestDTO);
		Profile updatedProfile = Profile.updateProfile(profile, profileUpdateModelDTO);
		if (!profileUpdateModelDTO.getNickname().equals(profile.getNickname())) {
			MemberNicknameUpdateRequestEvent memberNicknameUpdateRequestEvent = MemberNicknameUpdateRequestEvent.builder()
				.memberUUID(profile.getMemberUUID())
				.nickname(profileUpdateModelDTO.getNickname())
				.build();
			eventPublisher.publish(nicknameUpdateRequestTopic, memberNicknameUpdateRequestEvent);
		}
		if (!profileUpdateModelDTO.getProfileImage().equals(profile.getProfileImage())) {
			MemberProfilePictureUpdateEvent memberProfilePictureUpdateEvent = MemberProfilePictureUpdateEvent.builder()
				.memberUUID(profile.getMemberUUID())
				.picture(profileUpdateModelDTO.getProfileImage())
				.build();
			eventPublisher.publish(profilePictureUpdateTopic, memberProfilePictureUpdateEvent);
		}
		profilePersistence.update(profileDomainDTOMapper.toDTO(updatedProfile));
	}

	@Override
	public ProfileShortDTO getShort(String memberUUID) {
		ProfileDTO profileDTO = profilePersistence.read(memberUUID);
		return profileDomainDTOMapper.toShortDTO(profileDTO);
	}

	@Override
	public ProfileShortDTO getShortByNickname(String nickname) {
		ProfileDTO profileDTO = profilePersistence.readByNickname(nickname);
		return profileDomainDTOMapper.toShortDTO(profileDTO);
	}

	@Override
	public List<ProfileShortDTO> search(String query) {
		profilePersistence.search(query);
		return List.of();
	}
}
