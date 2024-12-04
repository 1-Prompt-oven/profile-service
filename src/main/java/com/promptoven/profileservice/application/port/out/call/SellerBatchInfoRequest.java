package com.promptoven.profileservice.application.port.out.call;

import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;

public interface SellerBatchInfoRequest {

	SellerStatisticDTO getStatistics(String memberUUID);

	boolean checkHealth();
}
