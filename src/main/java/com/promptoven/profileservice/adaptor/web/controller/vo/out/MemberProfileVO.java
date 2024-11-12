package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import org.springframework.lang.Nullable;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemberProfileVO {
    private String memberUUID;
    private String nickname;
    
    @Nullable
    private String profileImage;

    public static MemberProfileVO fromDTO(ProfileDTO profileDTO) {
        if (profileDTO == null) {
            return null;
        }
        
        return MemberProfileVO.builder()
            .memberUUID(profileDTO.getMemberUUID())
            .nickname(profileDTO.getNickname())
            .profileImage(profileDTO.getProfileImage())
            .build();
    }
} 