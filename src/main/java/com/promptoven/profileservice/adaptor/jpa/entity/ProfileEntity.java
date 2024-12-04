package com.promptoven.profileservice.adaptor.jpa.entity;

import java.time.LocalDateTime;

import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(indexes = {
	@Index(name = "idx_uuid", columnList = "memberUUID"),
	@Index(name = "idx_nickname", columnList = "nickname")
})
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String memberUUID;
	private String nickname;
	private LocalDateTime createdAt;

	@Nullable
	@Column(length = 400)
	private String banner;
	@Nullable
	@Column(length = 400)
	private String profileImage;
	@Nullable
	private String hashtag;
	@Column(length = 3000)
	private String bio;
	@Nullable
	private String email;
	private boolean isWithdrew;
	private boolean isBanned;
	private boolean isCreator;

	public void setId(Long id) {
		this.Id = id;
	}

}
