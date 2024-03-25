package com.customerRegistrationBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerRegistrationBackEnd.entities.ClienteEntity;
import com.customerRegistrationBackEnd.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    /**
     * @return retona Lista de clientes
     */
    @GetMapping
    public List<ClienteEntity> listarClientes() {
        return clienteService.listarClientes();
    }

    /**
     * @param cliente metodo para cadastrar Clientes
     * @return
     */
    @PostMapping
    public ClienteEntity cadastrarCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

}
