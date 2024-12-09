package com.promptoven.profileservice.application.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promptoven.profileservice.application.port.out.call.ProfilePersistence;
import com.promptoven.profileservice.application.port.out.call.ProfileStatisticsPersistence;
import com.promptoven.profileservice.application.port.out.call.SellerBatchInfoRequest;
import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProfileAggregateTraceService {

	private final SellerBatchInfoRequest sellerBatchInfoRequest;
	private final ProfilePersistence profilePersistence;
	private final ProfileStatisticsPersistence profileStatisticsPersistence;

	private void applySellingCounts(String profileId) {
		SellerStatisticDTO extractedSellerStatisticDTO =
			sellerBatchInfoRequest.getStatistics(profileId, LocalDate.now());
		if (null != extractedSellerStatisticDTO.getMemberUUID()) {
			SellerStatisticDTO sellerStatisticDTO = SellerStatisticDTO.builder()
				.memberUUID(profileId)
				.rank(extractedSellerStatisticDTO.getRank())
				.sales(extractedSellerStatisticDTO.getSales())
				.reviewAvg(extractedSellerStatisticDTO.getReviewAvg())
				.build();
			profileStatisticsPersistence.updateSellerStatistics(sellerStatisticDTO);
		}
	}

	@Scheduled(cron = "0 0 2 * * *") // Runs at 02:00 UTC daily
	private void applyAllProfileSellingCounts() {
		try {
			if (sellerBatchInfoRequest.checkHealth()) {
				profilePersistence.getAllProfileIDs()
					.forEach(profileId -> CompletableFuture.runAsync(() -> applySellingCounts(profileId)));
			} else {
				log.error("Seller batch service is not healthy");
			}
		} catch (Exception e) {
			log.error("Error during scheduled profile seller stat update application", e);
		}
	}
}
