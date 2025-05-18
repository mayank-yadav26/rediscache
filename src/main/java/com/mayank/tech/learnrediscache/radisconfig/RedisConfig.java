package com.mayank.tech.learnrediscache.radisconfig;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfig {

    // @Bean
    // public RedisCacheConfiguration redisCacheConfiguration() {
    //     return RedisCacheConfiguration.defaultCacheConfig()
    //         .entryTtl(Duration.ofMinutes(10)) // default TTL
    //         .disableCachingNullValues();
    // }

    // @Bean
    // public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    //     return RedisCacheManager.builder(redisConnectionFactory)
    //         .cacheDefaults(redisCacheConfiguration())
    //         .build();
    // }
}

