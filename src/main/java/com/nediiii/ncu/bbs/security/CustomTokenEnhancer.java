package com.nediiii.ncu.bbs.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        // token扩展信息
        Map<String, Object> tokenEnhanceInfo = new HashMap<>();
        tokenEnhanceInfo.put("test", "value");

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(tokenEnhanceInfo);

        return oAuth2AccessToken;
    }
}
