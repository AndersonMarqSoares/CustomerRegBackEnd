package com.customerRegistrationBackEnd.dtos;


import java.util.List;

public class ClienteDTO {

        
    private String nome;
    private String endereco;
    private String bairro;
    private List<TelefoneDTO> telefones;

    public ClienteDTO(String nome, String endereco, String bairro) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
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
     * @return retorna lista de Telefones
     */
    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones define a lista de telefones
     */
    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    
}
