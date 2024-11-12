package com.promptoven.profileservice.adaptor.infrastructure.mongo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.ProfileDocument;
import com.promptoven.profileservice.adaptor.infrastructure.mongo.document.ProfileDocument.ProfileStatus;

@Repository
public interface ProfileMongoRepository extends MongoRepository<ProfileDocument, String> {
    @Query("{ 'nickname': ?0, 'status': { $ne: 'WITHDRAWN' } }")
    Optional<ProfileDocument> findByNicknameAndNotWithdrawn(String nickname);
    
    @Query("{ 'memberUUID': ?0, 'status': { $ne: 'WITHDRAWN' } }")
    Optional<ProfileDocument> findByMemberUUIDAndNotWithdrawn(String memberUUID);
    
    @Query("{ 'status': 'ACTIVE', 'visibility': 'PUBLIC', 'isCreator': true }")
    List<ProfileDocument> findAllActivePublicCreators();
    
    @Query(value = "{ 'status': 'ACTIVE', 'visibility': 'PUBLIC', 'isCreator': true }",
           sort = "{ 'followerCount': -1 }")
    List<ProfileDocument> findTop10ByFollowerCount();
    
    boolean existsByNicknameAndStatusNot(String nickname, ProfileStatus status);
    
    @Query("{ 'status': 'ACTIVE', $or: [ " +
           "{ 'visibility': 'PUBLIC' }, " +
           "{ 'visibility': 'PRIVATE', 'isCreator': true } " +
           "] }")
    List<ProfileDocument> findAllAccessibleProfiles();
}
