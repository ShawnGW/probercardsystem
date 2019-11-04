package com.vtest.it.springcloudprobercardservice.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class RedisConfiguration {

    @Bean("cacheManager")
    @Primary
    public CacheManager getManager(JedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues();
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("ProberCardCache");
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap.put("ProberCardCache", configuration);
        return RedisCacheManager.builder(connectionFactory).initialCacheNames(cacheNames).withInitialCacheConfigurations(cacheConfigurationMap).build();
    }

}
