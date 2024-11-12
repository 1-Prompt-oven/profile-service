package com.promptoven.profileservice.adaptor.infrastructure.mongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.FollowDocument;

@Repository
public interface FollowMongoRepository extends MongoRepository<FollowDocument, String> {
    List<FollowDocument> findByFollowerIdAndIsActiveTrue(String followerId);
    List<FollowDocument> findByFollowingIdAndIsActiveTrue(String followingId);
    Optional<FollowDocument> findByFollowerIdAndFollowingId(String followerId, String followingId);
    long countByFollowingIdAndIsActiveTrue(String followingId);
    long countByFollowerIdAndIsActiveTrue(String followerId);
} 