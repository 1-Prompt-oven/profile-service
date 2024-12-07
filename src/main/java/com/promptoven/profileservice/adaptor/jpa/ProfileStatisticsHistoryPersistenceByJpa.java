package com.promptoven.profileservice.adaptor.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Pair;
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
	public List<ProfileStatisticsHistoryDTO> get(Pair<LocalDate, LocalDate> range, String targetUUID) {

		LocalDate beginDate = range.getFirst();
		LocalDate endDate = range.getSecond();

		List<ProfileStatisticsHistoryEntity> profileStatisticsHistoryEntityList =
			profileStatisticsHistoryRepository.findByMemberUUIDAndTargetDate(targetUUID, beginDate, endDate);

		return profileStatisticsHistoryEntityList.stream()
			.map(JpaProfileStatisticsHistoryDTOEntityMapper::toDTO)
			.toList();
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
