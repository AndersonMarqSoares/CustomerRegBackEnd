package com.customerRegistrationBackEnd.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@EntityScan
public class TelefoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero;

    /**
     * @return retorna o Id do Cliente
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param define o valor de Id para o Cliente
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return retorna o numero do Telefone
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param define o numero do Telefone
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }


}
