package com.promptoven.profileservice.adaptor.jpa;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsHistoryEntity;
import com.promptoven.profileservice.adaptor.jpa.repository.ProfileStatisticsHistoryRepository;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsHistoryPersistence;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsHistoryDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileStatisticsHistoryPersistenceByJpa implements ProfileStatisticsHistoryPersistence {

	private final ProfileStatisticsHistoryRepository profileStatisticsHistoryRepository;

	@Override
	public void record(ProfileStatisticsHistoryDTO profileStatisticsHistoryDTO) {
		profileStatisticsHistoryRepository.save(
			JpaProfileStatisticsHistoryDTOEntityMapper.toEntity(profileStatisticsHistoryDTO));
	}

	@Override
	public ProfileStatisticsHistoryDTO get(LocalDate targetDate, String targetUUID) {

		ProfileStatisticsHistoryEntity profileStatisticsHistoryEntity
			= profileStatisticsHistoryRepository.findByMemberUUIDAndTargetDate(targetUUID, targetDate);

		if (null == profileStatisticsHistoryEntity) {
			return null;
		}
		return JpaProfileStatisticsHistoryDTOEntityMapper
			.toDTO(profileStatisticsHistoryEntity);
	}

	private static class JpaProfileStatisticsHistoryDTOEntityMapper {
		static ProfileStatisticsHistoryEntity toEntity(ProfileStatisticsHistoryDTO profileStatisticsHistoryDTO) {
			return ProfileStatisticsHistoryEntity.builder()
				.memberUUID(profileStatisticsHistoryDTO.getMemberUUID())
				.sales(profileStatisticsHistoryDTO.getSales())
				.rank(profileStatisticsHistoryDTO.getRank())
				.follower(profileStatisticsHistoryDTO.getFollower())
				.targetDate(profileStatisticsHistoryDTO.getTargetDate())
				.viewer(profileStatisticsHistoryDTO.getViewer())
				.rating(profileStatisticsHistoryDTO.getRating())
				.build();
		}

		static ProfileStatisticsHistoryDTO toDTO(ProfileStatisticsHistoryEntity profileStatisticsHistoryEntity) {
			return ProfileStatisticsHistoryDTO.builder()
				.targetDate(profileStatisticsHistoryEntity.getTargetDate())
				.memberUUID(profileStatisticsHistoryEntity.getMemberUUID())
				.sales(profileStatisticsHistoryEntity.getSales())
				.rank(profileStatisticsHistoryEntity.getRank())
				.viewer(profileStatisticsHistoryEntity.getViewer())
				.follower(profileStatisticsHistoryEntity.getFollower())
				.rating(profileStatisticsHistoryEntity.getRating())
				.build();
		}
	}
}
