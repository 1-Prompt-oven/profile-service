package com.promptoven.profileservice.application.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.service.dto.FollowingDTO;
import com.promptoven.profileservice.application.service.dto.ProfileDTO;
import com.promptoven.profileservice.application.service.dto.mapper.FollowingDomainDTOMapper;
import com.promptoven.profileservice.application.service.dto.mapper.ProfileDomainDTOMapper;
import com.promptoven.profileservice.domain.Following;
import com.promptoven.profileservice.domain.Profile;
import com.promptoven.profileservice.domain.dto.FollowingModelDTO;
import com.promptoven.profileservice.domain.dto.ProfileModelDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileCommonService
	//implements ProfileUseCase
{

	private final ProfileDomainDTOMapper profileDomainDTOMapper;
	private final FollowingDomainDTOMapper followingDomainDTOMapper;

	public void follow(String profileId, String followerId) {
		FollowingModelDTO followingModelDTO = FollowingModelDTO.builder()
			.FollowerID(followerId)
			.FolloweeID(profileId)
			.build();
		Following following = Following.CreateFollowing(followingModelDTO);
		FollowingDTO followingDTO = followingDomainDTOMapper.toDTO(following);
		// followingPersistence.save(followingDTO);
	}

	public void unfollow(String nickname, String followerId) {
		// Following following = followingPersistence.getFollowingByFollowerAndFollowee(followerId, getMemberUUID(nickname));
		// followingPersistence.save(followingDomainDTOMapper.toDTO(Following.Unfollow(following)));
	}

	public void updateProfile(ProfileDTO profileDTO) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(profileDTO.getMemberUUID());
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.updateProfile(profile, profileDTO)));
	}

	public ProfileDTO getProfile(String nickname) {
		// return profilePersistence.getProfileByNickname(nickname);
		return null;
	}

	public Collection<Object> getFollowers(String nickname) {
		// return followingPersistence.getFollowersByFollowee(getMemberUUID(nickname));
		return List.of();
	}

	public Collection<Object> getFollowing(String nickname) {
		// return followingPersistence.getFollowingByFollower(getMemberUUID(nickname));
		return List.of();
	}

	public Object getProfileCount(String nickname) {
		// return profilePersistence.getProfileCountByNickname(nickname);
		return null;
	}

	public void withdrawProfile(String memberUUID) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.withdrawProfile(profile)));
	}

	public void banProfile(String memberUUID) {
		// Profile profile = profilePersistence.getProfileByMemberUUID(memberUUID);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(Profile.banProfile(profile)));
	}

	public ProfileDTO getProfileByMemberUUID(String memberUUID) {
		// return profilePersistence.getProfileByMemberUUID(memberUUID);
		return null;
	}

	public void createProfile(ProfileModelDTO profileModelDTO) {
		Profile profile = Profile.createProfile(profileModelDTO);
		// profilePersistence.SaveProfile(profileDomainDTOMapper.toDTO(profile));
	}

	private String getMemberUUID(String nickname) {
		// return profilePersistence.getProfileByNickname(nickname).getMemberUUID();
		return null;
	}
}
