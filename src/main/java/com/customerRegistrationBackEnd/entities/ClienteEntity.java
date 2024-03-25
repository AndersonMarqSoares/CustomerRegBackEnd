package com.customerRegistrationBackEnd.entities;


import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;



@EntityScan
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<TelefoneEntity> telefones;

    
    /**
     *  Constructor padrão
     */
    public ClienteEntity() {
    }

    /**
     *  Metodo constructor com preenchimento de 3 campos: nome, endereco e bairro
     * @param nome
     * @param endereco
     * @param bairro
     */
    public ClienteEntity(Long id,String nome, String endereco, String bairro) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
    }

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
     * @return retorna o nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param define o nome do Cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return retorna o endereço do Cliente
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param define o Endereço do Cliente
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return retorna o Bairro do Cliente
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param define o Bairro do Cliente
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return retorna a lista de Telefones
     */
    public List<TelefoneEntity> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones define a lista de Telefones
     */
    public void setTelefones(List<TelefoneEntity> telefones) {
        this.telefones = telefones;
    }


    
}
