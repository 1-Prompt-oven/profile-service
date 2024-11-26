package com.promptoven.profileservice.adaptor.jpa;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;
import com.promptoven.profileservice.adaptor.jpa.repository.ProfileRepository;
import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;

import java.util.List;
import java.util.stream.Collectors;

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
		return JpaProfileDTOEntityMapper.toDTO(profileRepository.findByMemberUUID(profileID));
	}

	@Override
	public void update(ProfileDTO profileDTO) {

	}

	@Override
	public String getProfileID(String nickname) {
		ProfileEntity profileEntity = profileRepository.findByNickname(nickname);
		return profileEntity.getMemberUUID();
	}

	@Override
	public List<String> getAllProfileIDs() {
		return profileRepository.findAll().stream().map(ProfileEntity::getMemberUUID).collect(Collectors.toList());
	}
}
