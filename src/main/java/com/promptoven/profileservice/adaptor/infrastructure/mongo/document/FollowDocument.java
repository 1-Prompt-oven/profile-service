package com.promptoven.profileservice.adaptor.infrastructure.mongo.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "follows")
@CompoundIndex(def = "{'followerId': 1, 'followingId': 1}", unique = true)
public class FollowDocument {
    @Id
    private String id;
    private String followerId;
    private String followingId;
    
    @CreatedDate
    private LocalDateTime followedAt;
    private boolean isActive;

    public static FollowDocument createFollow(String followerId, String followingId) {
        return FollowDocument.builder()
            .followerId(followerId)
            .followingId(followingId)
            .isActive(true)
            .build();
    }

    public static FollowDocument unfollow(FollowDocument followDocument) {
        return FollowDocument.builder()
            .id(followDocument.getId())
            .followerId(followDocument.getFollowerId())
            .followingId(followDocument.getFollowingId())
            .followedAt(followDocument.getFollowedAt())
            .isActive(false)
            .build();
    }

    public static FollowDocument refollow(FollowDocument followDocument) {
        return FollowDocument.builder()
            .id(followDocument.getId())
            .followerId(followDocument.getFollowerId())
            .followingId(followDocument.getFollowingId())
            .followedAt(LocalDateTime.now())
            .isActive(true)
            .build();
    }
} 