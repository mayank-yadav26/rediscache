package com.mayank.tech.learnrediscache.radisconfig;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * Redis Configuration
 * This is custom configuration for Redis Cache
 * @author Mayank
 */
@Configuration
public class RedisConfig {
    // This is the default configuration for Redis Cache
    // Uncomment this if you want to use default configuration for all caches
    // @Bean
    // public RedisCacheConfiguration redisCacheConfiguration() {
    // return RedisCacheConfiguration.defaultCacheConfig()
    // .entryTtl(Duration.ofMinutes(10)) // default TTL
    // .disableCachingNullValues();
    // }

    // @Bean
    // public CacheManager cacheManager(RedisConnectionFactory
    // redisConnectionFactory) {
    // return RedisCacheManager.builder(redisConnectionFactory)
    // .cacheDefaults(redisCacheConfiguration())
    // .build();
    // }

    /**
     * Redis Cache Configuration
     * You can define TTL per cache like this, here we are defining
     * TTL for products and users cache
     * ✅ Auto-configured CacheManager is enough for simple use cases.
     * Custom CacheManager is useful for advanced needs (TTL, serialization,
     * multiple configs).
     * It’s good practice to define it once you grow beyond basic caching.
     * 
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

        cacheConfigurations.put("products", RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1)));

        cacheConfigurations.put("users", RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1)));

        return RedisCacheManager.builder(redisConnectionFactory)
                .withInitialCacheConfigurations(cacheConfigurations)
                .build();
    }

}
