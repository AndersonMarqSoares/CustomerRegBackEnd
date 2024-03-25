package com.customerRegistrationBackEnd.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.customerRegistrationBackEnd.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    /**
     *  Metodos para acessar e manipular o banco de dados
     */
    
}