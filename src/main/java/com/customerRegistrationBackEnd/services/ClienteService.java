package com.customerRegistrationBackEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.customerRegistrationBackEnd.entities.ClienteEntity;
import com.customerRegistrationBackEnd.entities.TelefoneEntity;
import com.customerRegistrationBackEnd.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    /**
     * @param clienteRepository
     */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return Uma lista de clientes.
     */
    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param id O ID do cliente a ser buscado.
     * @return O cliente encontrado, ou null se não encontrado.
     */
    public ClienteEntity buscarClientePorId(Long id) {
        Optional<ClienteEntity> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    /**
     * Cadastra um novo cliente.
     *
     * @param cliente O cliente a ser cadastrado.
     * @return O cliente cadastrado.
     */
    public ClienteEntity cadastrarCliente(ClienteEntity cliente) {
        if (validarTelefone(cliente.getTelefones())) {
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("O telefone não é válido.");
        }
    }

    /**
     * Atualiza os dados de um cliente.
     *
     * @param id      O ID do cliente a ser atualizado.
     * @param cliente O objeto com os novos dados do cliente.
     * @return O cliente atualizado, ou null se o ID não existir.
     */
    public ClienteEntity atualizarCliente(Long id, ClienteEntity cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    /**
     * Deleta um cliente pelo ID.
     *
     * @param id O ID do cliente a ser deletado.
     * @return true se o cliente foi deletado com sucesso, false se o ID não existir.
     */
    public boolean deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * @param telefone Metodo para validar o campo telefone e com 9 digitos
     * @return
     */
    private boolean validarTelefone(List<TelefoneEntity> telefones) {
        for (TelefoneEntity telefone : telefones) {
            if (telefone.getNumero() == null || telefone.getNumero().length() != 9) {
                return false; // Telefone inválido
            }
        }
        return true;
    }
}