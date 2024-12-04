package com.promptoven.profileservice.adaptor.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileStatisticsEntity;
import com.promptoven.profileservice.adaptor.jpa.repository.ProfileStatisticsRepository;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;
import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;
import com.promptoven.profileservice.application.service.dto.ProfileStatisticsDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileStatisticsPersistenceByJpa implements ProfileStatisticsPersistence {

	private final ProfileStatisticsRepository profileStatisticsRepository;

	@Override
	@Transactional
	public void addProfileViewCount(String profileUUID, Long count) {
		profileStatisticsRepository.addProfileViewCount(profileUUID, count);
	}

	@Override
	public void create(ProfileStatisticsDTO profileStatisticsDTO) {
		profileStatisticsRepository.save(JpaProfileStatisticsDTOEntityMapper.toEntity(profileStatisticsDTO));
	}

	@Override
	public ProfileStatisticsDTO get(String memberUUID) {
		return JpaProfileStatisticsDTOEntityMapper.toDTO(profileStatisticsRepository.findByMemberUUID(memberUUID));
	}

	@Override
	public void updateSellerStatues(SellerStatisticDTO sellerStatisticDTO) {

		ProfileStatisticsEntity oldProfileStatisticsEntity
			= profileStatisticsRepository.findByMemberUUID(sellerStatisticDTO.getMemberUUID());

		// 판매자 통계를 뽑았을 때 null 이면 기존 값 그대로 이용하게 처리하는 새 엔티티 인스턴스 생성로직
		ProfileStatisticsEntity updatedProfileStatisticsEntity = ProfileStatisticsEntity.builder()
			.Id(oldProfileStatisticsEntity.getId())
			.memberUUID(oldProfileStatisticsEntity.getMemberUUID())
			.viewer(oldProfileStatisticsEntity.getViewer())
			.rating(oldProfileStatisticsEntity.getRating())
			.sales(sellerStatisticDTO.getSales() != null ? sellerStatisticDTO.getSales() :
				oldProfileStatisticsEntity.getSales())
			.rank(sellerStatisticDTO.getRank() != null ? sellerStatisticDTO.getRank() :
				oldProfileStatisticsEntity.getRank())
			.build();
		
		profileStatisticsRepository.save(updatedProfileStatisticsEntity);
	}
}
