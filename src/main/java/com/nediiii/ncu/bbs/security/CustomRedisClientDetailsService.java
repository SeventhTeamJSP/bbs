package com.nediiii.ncu.bbs.security;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomRedisClientDetailsService implements ClientDetailsService {
    private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

    private Map<String, ClientDetails> clientDetailsStore = new HashMap<String, ClientDetails>();

    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        final ClientDetails details = clientDetailsStore.get(clientId);
        if (details == null) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        return details;
    }

    public void setClientDetailsStore(final Map<String, ? extends ClientDetails> clientDetailsStore) {
        this.clientDetailsStore = new HashMap<String, ClientDetails>(clientDetailsStore);
    }

    /**
     * @param passwordEncoder the password encoder to set
     */
    public void setPasswordEncoder(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
