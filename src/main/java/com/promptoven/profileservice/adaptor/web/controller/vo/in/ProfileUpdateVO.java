package com.promptoven.profileservice.adaptor.web.controller.vo.in;

import org.springframework.lang.Nullable;

import com.promptoven.profileservice.application.in.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateVO {
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

    public ProfileDTO toDTO() {
        return ProfileDTO.builder()
            .memberUUID(this.memberUUID)
            .nickname(this.nickname)
            .xId(this.xId)
            .instagramId(this.instagramId)
            .youtubeHandle(this.youtubeHandle)
            .webLink(this.webLink)
            .bio(this.bio)
            .banner(this.banner)
            .profileImage(this.profileImage)
            .build();
    }
}
