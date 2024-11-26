package com.promptoven.profileservice.adaptor.web.controller.vo.out;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private String bannerImageUrl;
	@Nullable
	private String avatarImageUrl;
	@Nullable
	private String hashTag;
	@Nullable
	private String bio;
	@Nullable
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime joined;

	private int following;
	private int follower;
	private int viewer;
	private int sales;

	private boolean isViewStatus;
	
}
