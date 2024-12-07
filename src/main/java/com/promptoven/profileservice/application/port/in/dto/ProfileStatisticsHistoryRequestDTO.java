package com.promptoven.profileservice.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class ProfileStatisticsHistoryRequestDTO {

    private final String memberUUID;
    private final LocalDate beginDate;
    private final LocalDate endDate;
}
