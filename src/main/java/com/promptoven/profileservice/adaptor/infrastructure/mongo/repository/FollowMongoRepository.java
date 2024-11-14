package com.promptoven.profileservice.adaptor.infrastructure.mongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.FollowDocument;

public interface FollowMongoRepository extends MongoRepository<FollowDocument, String> {
	Optional<FollowDocument> findByFollowerIdAndFollowingId(String followerId, String followingId);
	List<FollowDocument> findByFollowingIdAndIsActiveTrue(String followingId);
}
