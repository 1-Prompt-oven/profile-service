package com.promptoven.profileservice.adaptor.jpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;
import com.promptoven.profileservice.adaptor.jpa.repository.ProfileRepository;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfilePersistenceByJpa implements ProfilePersistence {

	private final ProfileRepository profileRepository;

	@Override
	public void create(ProfileDTO profileDTO) {
		profileRepository.save(JpaProfileDTOEntityMapper.toEntity(profileDTO));
	}

	@Override
	public ProfileDTO read(String profileID) {
		ProfileEntity profileEntity = profileRepository.findByMemberUUID(profileID);
		if (profileEntity.isWithdrew()) {
			return null;
		}
		return JpaProfileDTOEntityMapper.toDTO(profileEntity);
	}

	@Override
	public ProfileDTO readByNickname(String nickname) {
		ProfileEntity profileEntity = profileRepository.findByNickname(nickname);
		if (profileEntity.isWithdrew()) {
			return null;
		}
		return JpaProfileDTOEntityMapper.toDTO(profileEntity);
	}

	@Override
	public void update(ProfileDTO profileDTO) {
		ProfileEntity profileEntity = JpaProfileDTOEntityMapper.toEntity(profileDTO);
		profileEntity.setId(profileRepository.findByMemberUUID(profileDTO.getMemberUUID()).getId());
		profileRepository.save(profileEntity);
	}

	@Override
	public String getProfileID(String nickname) {
		String profileID = profileRepository.findIDByNickname(nickname);
		if (null == profileID) {
			return null;
		}
		return profileID;
	}

	@Override
	public List<String> getAllProfileIDs() {
		return profileRepository.findAllProfileIDs();
	}

	@Override
	public List<ProfileDTO> search(String query) {
		List<ProfileDTO> nicknameSearchResult = profileRepository.findByNicknameContaining(query)
			.stream()
			.filter(profileEntity -> !profileEntity.isBanned() && !profileEntity.isWithdrew())
			.map(JpaProfileDTOEntityMapper::toDTO)
			.collect(Collectors.toList());
		List<ProfileDTO> hashtagSearchResult = profileRepository.findByHashtagContaining(query)
			.stream()
			.filter(profileEntity -> !profileEntity.isBanned() && !profileEntity.isWithdrew())
			.map(JpaProfileDTOEntityMapper::toDTO)
			.collect(Collectors.toList());
		List<ProfileDTO> bioSearchResult = profileRepository.findByBioContaining(query)
			.stream()
			.filter(profileEntity -> !profileEntity.isBanned() && !profileEntity.isWithdrew())
			.map(JpaProfileDTOEntityMapper::toDTO)
			.collect(Collectors.toList());
		return Stream.of(nicknameSearchResult, hashtagSearchResult, bioSearchResult)
			.flatMap(List::stream)
			.distinct()
			.collect(Collectors.toList());

	}

	@Override
	public String getPicture(String memberUUID) {
		String picture = profileRepository.findPictureByID(memberUUID);
		if (null == picture) {
			return null;
		}
		return picture;
	}

}
