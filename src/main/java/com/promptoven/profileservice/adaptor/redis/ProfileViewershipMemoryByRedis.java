package com.promptoven.profileservice.adaptor.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.promptoven.profileservice.application.port.out.call.ProfileViewershipMemory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileViewershipMemoryByRedis implements ProfileViewershipMemory {

	private static final String KEY_PREFIX = "profile:view:";
	private final RedisTemplate<String, Long> redisTemplate;

	@Override
	public void addViewCount(String profileUUID) {

		String key = KEY_PREFIX + profileUUID;
		Long currentValue = redisTemplate.opsForValue().get(key);
		if (currentValue == null) {
			redisTemplate.opsForValue().set(key, 1L);
		} else {
			redisTemplate.opsForValue().increment(key);
		}

	}

	@Override
	public Long getAndResetViewCount(String profileUUID) {
		String key = KEY_PREFIX + profileUUID;
		return redisTemplate.opsForValue().getAndSet(key, 0L);
	}
}
