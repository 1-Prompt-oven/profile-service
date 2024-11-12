package com.promptoven.profileservice.adaptor.infrastructure.persistence;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.adaptor.infrastructure.jpa.entity.ProfileEntity;
import com.promptoven.profileservice.adaptor.infrastructure.jpa.repository.ProfileRepository;
import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.ProfileDocument;
import com.promptoven.profileservice.adaptor.infrastructure.mongo.repository.ProfileMongoRepository;
import com.promptoven.profileservice.application.out.call.ProfilePersistence;
import com.promptoven.profileservice.domain.Profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfilePersistenceAdapter implements ProfilePersistence {

    private final ProfileRepository profileRepository;
    private final ProfileMongoRepository profileMongoRepository;

    @Override
    public void CreateProfile(Profile profile) {
        // Save to JPA
        ProfileEntity profileEntity = ProfileEntity.fromDomain(profile);
        profileRepository.save(profileEntity);

        // Save to MongoDB
        ProfileDocument profileDocument = ProfileDocument.fromDomain(profile);
        profileMongoRepository.save(profileDocument);
    }

    @Override
    public void UpdateProfile(Profile profile) {
        // Update JPA
        ProfileEntity profileEntity = ProfileEntity.fromDomain(profile);
        profileRepository.save(profileEntity);

        // Update MongoDB
        profileMongoRepository.findByMemberUUIDAndNotWithdrawn(profile.getMemberUUID())
            .map(existingDoc -> ProfileDocument.updateProfile(existingDoc, profile))
            .ifPresent(profileMongoRepository::save);
    }

    @Override
    public Profile getProfileByNickname(String nickname) {
        return profileMongoRepository.findByNicknameAndNotWithdrawn(nickname)
            .map(ProfileDocument::toDomain)
            .orElse(null);
    }

    @Override
    public Profile getProfileByProfileID(String profileID) {
        return profileMongoRepository.findByMemberUUIDAndNotWithdrawn(profileID)
            .map(ProfileDocument::toDomain)
            .orElse(null);
    }

    public void banProfile(String memberUUID, String reason) {
        profileMongoRepository.findByMemberUUIDAndNotWithdrawn(memberUUID)
            .map(profile -> ProfileDocument.ban(profile, reason))
            .ifPresent(profileMongoRepository::save);
    }

    public void withdrawProfile(String memberUUID) {
        profileMongoRepository.findByMemberUUIDAndNotWithdrawn(memberUUID)
            .map(doc -> ProfileDocument.withdraw(doc))
            .ifPresent(profileMongoRepository::save);
    }
} 