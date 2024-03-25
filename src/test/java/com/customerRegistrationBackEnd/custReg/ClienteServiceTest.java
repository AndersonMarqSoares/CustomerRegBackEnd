package com.customerRegistrationBackEnd.custReg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.customerRegistrationBackEnd.entities.ClienteEntity;
import com.customerRegistrationBackEnd.repository.ClienteRepository;
import com.customerRegistrationBackEnd.services.ClienteService;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     *      Teste de cadastro de Cliente.
     */
    @Test
    public void testCadastrarCliente() {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        clienteEntity.setNome("Teste");
        clienteEntity.setEndereco("Endereco");
        clienteEntity.setBairro("Bairro");

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        ClienteEntity result = clienteService.cadastrarCliente(clienteEntity);

        assertNotNull(result);
        assertEquals("Teste", result.getNome());
        assertEquals("Endereco", result.getEndereco());
        assertEquals("Bairro", result.getBairro());
    }
}
