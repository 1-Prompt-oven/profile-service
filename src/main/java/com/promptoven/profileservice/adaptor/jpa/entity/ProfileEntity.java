package com.promptoven.profileservice.adaptor.jpa.entity;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String memberUUID;
	private String nickname;
	private LocalDateTime createdAt;

	@Nullable
	private String banner;
	@Nullable
	private String profileImage;
	@Nullable
	private String hashtag;
	@Nullable
	private String bio;
	@Nullable
	private String email;

	public void setId(Long id) {
		this.Id = id;
	}

}