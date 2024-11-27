package com.promptoven.profileservice.adaptor.jpa.entity;

import java.time.LocalDateTime;

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
	@Index(name = "idx_follower", columnList = "follower"),
	@Index(name = "idx_followee", columnList = "followee")
})
public class FollowingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String follower;
	private String followee;
	private LocalDateTime FollowDate;
	private LocalDateTime UnfollowDate;

	public void setId(Long id) {
		this.Id = id;
	}

}
