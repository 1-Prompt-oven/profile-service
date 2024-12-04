package com.promptoven.profileservice.adaptor.web.webclient;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.promptoven.profileservice.application.port.out.call.SellerBatchInfoRequest;
import com.promptoven.profileservice.application.port.out.dto.SellerStatisticDTO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Slf4j
@Service
public class SellerBatchInfoRequestByWebclient implements SellerBatchInfoRequest {

	private final WebClient webClient;

	public SellerBatchInfoRequestByWebclient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://seller-batch-service").build();
	}

	@Override
	public SellerStatisticDTO getStatistics(String memberUUID) {
		return webClient.get()
			.uri("/v1/seller-batch/aggregate/{memberUuid}", memberUUID)
			.retrieve()
			.onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
				clientResponse -> clientResponse.bodyToMono(String.class)
					.flatMap(errorBody -> Mono.error(new RuntimeException("Error response: " + errorBody))))
			.bodyToMono(SellerStatisticsVO.class)
			.map(DtoVoMapper::toDTO)
			.retryWhen(Retry.backoff(3, Duration.ofMillis(100))
				.maxBackoff(Duration.ofMillis(400)))
			.onErrorResume(WebClientResponseException.class, ex -> {
				// Log the error and provide a fallback response
				log.warn("Error occurred: " + ex.getMessage());
				return Mono.just(new SellerStatisticDTO(null, null, null));
			})
			.block(); // Convert reactive to blocking
	}

	@Override
	public boolean checkHealth() {
		try {
			return webClient.get()
				.uri("/v1/seller-batch/aggregate/health-check-test")
				.retrieve()
				.toBodilessEntity()
				.map(response -> response.getStatusCode().is2xxSuccessful())
				.onErrorReturn(false)
				.block();
		} catch (Exception e) {
			return false;
		}
	}
}
