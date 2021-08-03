package com.example.modernapi.repository;

import com.example.modernapi.model.entity.ClientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity, String> {
}
