package br.com.alura.comex.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.dto.DadosCadastrarCliente;
import br.com.alura.comex.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping()
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastrarCliente dados) {
        clienteService.cadastrarCliente(dados);
    }
}
