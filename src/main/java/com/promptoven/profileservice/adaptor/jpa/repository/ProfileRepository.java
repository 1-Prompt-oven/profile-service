package com.promptoven.profileservice.adaptor.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promptoven.profileservice.adaptor.jpa.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
