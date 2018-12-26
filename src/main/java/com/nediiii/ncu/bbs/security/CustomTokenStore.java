package com.nediiii.ncu.bbs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class CustomTokenStore {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean(name = "CustomTokenStore")
    @ConditionalOnProperty(prefix = "com.nediiii.ncu.bbs", name = "token-store-type", havingValue = "redis", matchIfMissing = false)
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Configuration
    @ConditionalOnProperty(prefix = "com.nediiii.ncu.bbs", name = "token-store-type", havingValue = "jwt", matchIfMissing = true)
    public static class JwtTokenConfig {

        @Bean(name = "CustomTokenStore")
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            accessTokenConverter.setSigningKey("bbs");
            return accessTokenConverter;
        }

        @Bean
        public TokenEnhancer tokenEnhancer() {
            return new CustomTokenEnhancer();
        }
    }

}
