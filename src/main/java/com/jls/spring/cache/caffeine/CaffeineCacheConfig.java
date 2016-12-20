package com.jls.spring.cache.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Meetansh on 21-12-2016.
 */
@Configuration
public class CaffeineCacheConfig {

    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setAllowNullValues(true);
        caffeineCacheManager.setCaffeine(caffeineBuilder());
        return caffeineCacheManager;
    }

    @Bean
    public Caffeine<Object,Object> caffeineBuilder(){
        return Caffeine.newBuilder().initialCapacity(100)
                .maximumSize(100)
                .recordStats();
    }
}
