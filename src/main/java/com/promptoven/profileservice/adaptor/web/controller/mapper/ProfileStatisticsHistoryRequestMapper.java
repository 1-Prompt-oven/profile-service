package com.promptoven.profileservice.adaptor.web.controller.mapper;

import com.promptoven.profileservice.application.port.in.dto.ProfileStatisticsHistoryRequestDTO;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.util.Map;

public class ProfileStatisticsHistoryRequestMapper {

    public static ProfileStatisticsHistoryRequestDTO toDTO(String memberUUID, Pair<LocalDate,LocalDate> range){
        return ProfileStatisticsHistoryRequestDTO.builder()
                .memberUUID(memberUUID)
                .beginDate(range.getFirst())
                .endDate(range.getSecond())
                .build();
    }
}
