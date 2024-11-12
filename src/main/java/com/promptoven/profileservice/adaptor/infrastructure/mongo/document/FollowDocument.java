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
@Document(collection = "Follow")
@CompoundIndex(def = "{'followerId': 1, 'followingId': 1}", unique = true)
public class FollowDocument {
    @Id
    private String id;
    
    private String followerId;
    private String followingId;
    
    @CreatedDate
    private LocalDateTime followedAt;
    
    private boolean isActive;
} 