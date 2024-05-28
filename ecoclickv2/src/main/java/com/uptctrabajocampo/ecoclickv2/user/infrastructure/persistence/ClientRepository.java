package com.uptctrabajocampo.ecoclickv2.user.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uptctrabajocampo.ecoclickv2.user.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    Optional<Client> findByDocumentNumber(String documentNumber);
    Optional<Client> findByEmail(String email);
}
