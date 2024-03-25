package com.customerRegistrationBackEnd.dtos;

public class TelefoneDTO {
    private String numero;

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
