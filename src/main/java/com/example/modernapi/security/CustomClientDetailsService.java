package com.example.modernapi.security;

import com.example.modernapi.model.entity.ClientDetailsEntity;
import com.example.modernapi.repository.ClientDetailsRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    private ClientDetailsRepository clientDetailsRepository;


    public CustomClientDetailsService(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        ClientDetailsEntity client = clientDetailsRepository.findById(s).orElseThrow(() -> new EntityNotFoundException());
        return new CustomClientDetails(client);
    }
}
