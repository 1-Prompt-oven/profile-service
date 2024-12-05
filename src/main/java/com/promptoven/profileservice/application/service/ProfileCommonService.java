package com.promptoven.profileservice.application.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.in.dto.ProfilePictureResponseDTO;
import com.promptoven.profileservice.application.port.in.dto.ProfileResponseDTO;
import com.promptoven.profileservice.application.port.in.dto.ProfileUpdateRequestDTO;
import com.promptoven.profileservice.application.port.in.usecase.ProfileCommonUsecase;
import com.promptoven.profileservice.application.port.out.call.EventPublisher;
import com.promptoven.profileservice.application.port.out.call.FollowingPersistence;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;
import com.promptoven.profileservice.application.port.out.dto.MemberNicknameUpdateRequestEvent;
import com.promptoven.profileservice.application.port.out.dto.MemberProfilePictureUpdateEvent;
import com.promptoven.profileservice.application.service.dto.FollowStatDTO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.ProfileShortDTO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileDomainDTOMapper;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileResponseDTOMapper;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileCommonService implements ProfileCommonUsecase {

	private final FollowingPersistence followingPersistence;
	private final ProfilePersistence profilePersistence;
	private final ProfileDomainDTOMapper profileDomainDTOMapper;
	private final EventPublisher eventPublisher;
	private final ProfileStatisticsPersistence profileStatisticsPersistence;
	private final ProfileResponseDTOMapper profileResponseDTOMapper;

	@Value("${profile-nickname-update-request-event}")
	private String nicknameUpdateRequestTopic;
	@Value("${profile-picture-update-event}")
	private String profilePictureUpdateTopic;

	@Override
	public ProfileResponseDTO get(String memberUUID) {
		ProfileDTO profileDTO = profilePersistence.read(memberUUID);
		if (null == profileDTO) {
			return null;
		}
		ProfileStatisticsDTO profileStatisticsDTO = profileStatisticsPersistence.get(memberUUID);
		FollowStatDTO followStatDTO = FollowStatDTO.builder()
			.follower(followingPersistence.countFollowers(memberUUID))
			.following(followingPersistence.countFollowings(memberUUID))
			.build();
		return profileResponseDTOMapper.toDTO(profileDTO, profileStatisticsDTO, followStatDTO);
	}

	@Override
	public ProfileResponseDTO getByNickname(String nickname) {
		ProfileDTO profileDTO = profilePersistence.readByNickname(nickname);
		if (null == profileDTO) {
			return null;
		}
		ProfileStatisticsDTO profileStatisticsDTO = profileStatisticsPersistence.get(profileDTO.getMemberUUID());
		FollowStatDTO followStatDTO = FollowStatDTO.builder()
			.follower(followingPersistence.countFollowers(profileDTO.getMemberUUID()))
			.following(followingPersistence.countFollowings(profileDTO.getMemberUUID()))
			.build();
		return profileResponseDTOMapper.toDTO(profileDTO, profileStatisticsDTO, followStatDTO);
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
		if (null == profileDTO) {
			return null;
		}
		return profileDomainDTOMapper.toShortDTO(profileDTO);
	}

	@Override
	public ProfileShortDTO getShortByNickname(String nickname) {
		ProfileDTO profileDTO = profilePersistence.readByNickname(nickname);
		if (null == profileDTO) {
			return null;
		}
		return profileDomainDTOMapper.toShortDTO(profileDTO);
	}

	@Override
	public List<ProfileShortDTO> search(String query) {
		if (query == null) {
			return List.of();
		}
		// Sanitize and validate the query
		String safeQuery = query.trim()
			.replaceAll("[%_]", "\\\\$0"); // Escape SQL LIKE special characters
		
		if (safeQuery.isEmpty()) {
			return List.of();
		}
		
		return profilePersistence.search(safeQuery).stream()
			.filter(Objects::nonNull)
			.map(profileDomainDTOMapper::toShortDTO)
			.toList();
	}

	@Override
	public ProfilePictureResponseDTO getPicture(String memberUUID) {
		String picture = profilePersistence.getPicture(memberUUID);
		if (null == picture) {
			return null;
		}
		return ProfilePictureResponseDTO.builder()
			.memberUUID(memberUUID)
			.Picture(picture)
			.build();
	}
}
