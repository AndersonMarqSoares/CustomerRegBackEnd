package com.customerRegistrationBackEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * @param cadastrarCliente metodo para cadastrar Cliente
     * @return
     */
    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteEntity> cadastrarCliente(@Validated @RequestBody ClienteEntity clienteDTO) {
        ClienteEntity clienteEntity = clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteEntity);
    }

    /**
     * @param buscarCliente metodo para buscar cliente por Id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarClientePorId(@PathVariable Long id) {
        ClienteEntity clienteEntity = clienteService.buscarClientePorId(id);
        if (clienteEntity != null) {
            return ResponseEntity.ok(clienteEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
