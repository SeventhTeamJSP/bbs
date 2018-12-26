package com.nediiii.ncu.bbs.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomRedisClientDetailsServiceBuilder extends ClientDetailsServiceBuilder<CustomRedisClientDetailsServiceBuilder> {
    private Map<String, ClientDetails> clientDetails = new HashMap<String, ClientDetails>();

    private PasswordEncoder passwordEncoder; // for writing client secrets

    public CustomRedisClientDetailsServiceBuilder passwordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        return this;
    }

    @Override
    protected void addClient(
            final String clientId,
            final ClientDetails build) {

        clientDetails.put(clientId, build);
    }

    @Override
    protected ClientDetailsService performBuild() {
        final CustomRedisClientDetailsService redisClientDetailsService = new CustomRedisClientDetailsService();
        if (passwordEncoder != null) {
            // This is used to encode secrets as they are added to the database (if it isn't set then the user has top
            // pass in pre-encoded secrets)
            redisClientDetailsService.setPasswordEncoder(passwordEncoder);
        }

        redisClientDetailsService.setClientDetailsStore(clientDetails);
        return redisClientDetailsService;
    }

}
