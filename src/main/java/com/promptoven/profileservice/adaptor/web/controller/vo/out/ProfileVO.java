package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import org.springframework.lang.Nullable;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileVO {
    private String memberUUID;
    private String nickname;
    
    @Nullable
    private String xId;
    @Nullable
    private String instagramId;
    @Nullable
    private String youtubeHandle;
    @Nullable
    private String webLink;
    @Nullable
    private String bio;
    @Nullable
    private String banner;
    @Nullable
    private String profileImage;

    public static ProfileVO fromDTO(ProfileDTO profileDTO) {
        if (profileDTO == null) {
            return null;
        }
        
        return ProfileVO.builder()
            .memberUUID(profileDTO.getMemberUUID())
            .nickname(profileDTO.getNickname())
            .xId(profileDTO.getXId())
            .instagramId(profileDTO.getInstagramId())
            .youtubeHandle(profileDTO.getYoutubeHandle())
            .webLink(profileDTO.getWebLink())
            .bio(profileDTO.getBio())
            .banner(profileDTO.getBanner())
            .profileImage(profileDTO.getProfileImage())
            .build();
    }
}
