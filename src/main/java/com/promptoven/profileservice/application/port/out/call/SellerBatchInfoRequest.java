package com.promptoven.profileservice.application.port.out.call;

import java.time.LocalDate;

import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;

public interface SellerBatchInfoRequest {

	SellerStatisticDTO getStatistics(String memberUUID, LocalDate date);

	boolean checkHealth();
}
