package br.com.alura.comex.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.comex.dto.DadosCadastrarCliente;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrarCliente(DadosCadastrarCliente dados) {
        Cliente cliente = new Cliente(dados);
        // Criptografa a senha antes de salvar
        cliente.getUsuario().setSenha(passwordEncoder.encode(dados.senha()));
        clienteRepository.save(cliente);
    }
}
