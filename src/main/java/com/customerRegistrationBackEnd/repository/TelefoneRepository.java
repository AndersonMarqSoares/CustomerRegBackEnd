package com.customerRegistrationBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerRegistrationBackEnd.entities.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {

    /**
     *  Metodos para acessar e manipular o banco de dados
     */
}