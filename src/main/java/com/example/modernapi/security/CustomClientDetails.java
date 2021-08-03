package com.example.modernapi.security;

import com.example.modernapi.model.entity.ClientDetailsEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;


public class CustomClientDetails implements ClientDetails {

    private final ClientDetailsEntity clientDetailsEntity;

    public CustomClientDetails(ClientDetailsEntity clientDetailsEntity) {
        this.clientDetailsEntity = clientDetailsEntity;
    }

    @Override
    public String getClientId() {
        return clientDetailsEntity.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        if(clientDetailsEntity.getResourceIds() == null){
            return Collections.emptySet();
        }
        String[] strings = clientDetailsEntity.getResourceIds().split(",");
        return Set.of(strings);
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientDetailsEntity.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return clientDetailsEntity.getScope() != null;
    }

    @Override
    public Set<String> getScope() {
        String[] strings = clientDetailsEntity.getScope().split(",");
        return Set.of(strings);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        String[] strings = clientDetailsEntity.getAuthorizedGrantTypes().split(",");
        return Set.of(strings);
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        String[] strings = clientDetailsEntity.getWebServerRedirectUri().split(",");
        return Set.of(strings);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        String[] strings = clientDetailsEntity.getAuthorities().split(",");
        return List.of(strings).stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientDetailsEntity.getAccessTokenValidity();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientDetailsEntity.getRefreshTokenValidity();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
