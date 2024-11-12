package com.promptoven.profileservice.adaptor.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.FollowDocument;
import com.promptoven.profileservice.adaptor.infrastructure.mongo.repository.FollowMongoRepository;
import com.promptoven.profileservice.adaptor.infrastructure.mongo.repository.ProfileMongoRepository;
import com.promptoven.profileservice.application.out.call.FollowingPersistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FollowingPersistenceAdapter implements FollowingPersistence {

    private final FollowMongoRepository followMongoRepository;
    private final ProfileMongoRepository profileMongoRepository;

    @Override
    public void follow(String profileId, String followerId) {
        profileMongoRepository.findByMemberUUIDAndNotWithdrawn(profileId)
            .ifPresent(profile -> {
                profile.addFollower(followerId);
                profileMongoRepository.save(profile);

                FollowDocument followDoc = followMongoRepository.findByFollowerIdAndFollowingId(followerId, profileId)
                    .map(FollowDocument::refollow)
                    .orElseGet(() -> FollowDocument.createFollow(followerId, profileId));
                followMongoRepository.save(followDoc);
            });
    }

    @Override
    public void unfollow(String nickname, String followerId) {
        profileMongoRepository.findByNicknameAndNotWithdrawn(nickname)
            .ifPresent(profile -> {
                profile.removeFollower(followerId);
                profileMongoRepository.save(profile);

                followMongoRepository.findByFollowerIdAndFollowingId(followerId, profile.getMemberUUID())
                    .map(FollowDocument::unfollow)
                    .ifPresent(followMongoRepository::save);
            });
    }

    @Override
    public List<String> getFollowers(String nickname) {
        return profileMongoRepository.findByNicknameAndNotWithdrawn(nickname)
            .map(profile -> followMongoRepository.findByFollowingIdAndIsActiveTrue(profile.getMemberUUID())
                .stream()
                .map(FollowDocument::getFollowerId)
                .collect(Collectors.toList()))
            .orElse(List.of());
    }

    @Override
    public List<String> getFollowing(String nickname) {
        return profileMongoRepository.findByNicknameAndNotWithdrawn(nickname)
            .map(profile -> followMongoRepository.findByFollowerIdAndIsActiveTrue(profile.getMemberUUID())
                .stream()
                .map(FollowDocument::getFollowingId)
                .collect(Collectors.toList()))
            .orElse(List.of());
    }
} 