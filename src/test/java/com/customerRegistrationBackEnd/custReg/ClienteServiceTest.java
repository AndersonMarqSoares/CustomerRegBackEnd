package com.customerRegistrationBackEnd.custReg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
     *  Teste para validar o listar Clientes
     */
    @Test
    public void testListarClientes() {
        List<ClienteEntity> clientes = new ArrayList<>();
        clientes.add(new ClienteEntity(1L, "Cliente 1", "Endereço 1", "Bairro 1"));
        clientes.add(new ClienteEntity(2L, "Cliente 2", "Endereço 2", "Bairro 2"));

        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        List<ClienteEntity> listaClientes = clienteService.listarClientes();
        Assertions.assertEquals(2, listaClientes.size());
    }

    /**
     *  Teste para validar o buscar cliente por Id
     */
    @Test
    public void testBuscarClientePorId() {
        ClienteEntity cliente = new ClienteEntity(1L, "Cliente 1", "Endereço 1", "Bairro 1");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteEntity clienteEncontrado = clienteService.buscarClientePorId(1L);
        Assertions.assertNotNull(clienteEncontrado);
        Assertions.assertEquals("Cliente 1", clienteEncontrado.getNome());
    }

    /**
     *  Teste para validar o cadastrar Cliente
     */
    @Test
    public void testCadastrarCliente() {
        ClienteEntity cliente = new ClienteEntity(1L, "Novo Cliente", "Novo Endereço", "Novo Bairro");

        Mockito.when(clienteRepository.save(Mockito.any(ClienteEntity.class))).thenReturn(cliente);

        ClienteEntity clienteCadastrado = clienteService.cadastrarCliente(cliente);
        Assertions.assertNotNull(clienteCadastrado);
        Assertions.assertEquals("Novo Cliente", clienteCadastrado.getNome());
    }

    /**
     *  Teste para validar o atualizar Cliente
     */
    @Test
    public void testAtualizarCliente() {
        ClienteEntity cliente = new ClienteEntity(1L, "Cliente 1", "Endereço 1", "Bairro 1");

        Mockito.when(clienteRepository.existsById(1L)).thenReturn(true);
        Mockito.when(clienteRepository.save(Mockito.any(ClienteEntity.class))).thenReturn(cliente);

        ClienteEntity clienteAtualizado = clienteService.atualizarCliente(1L, cliente);
        Assertions.assertNotNull(clienteAtualizado);
        Assertions.assertEquals("Cliente 1", clienteAtualizado.getNome());
    }

    /**
     * Teste para validar o deletar Cliente
     */
    @Test
    public void testDeletarCliente() {
        Mockito.when(clienteRepository.existsById(1L)).thenReturn(true);

        boolean deletado = clienteService.deletarCliente(1L);
        Assertions.assertTrue(deletado);
    }
}
