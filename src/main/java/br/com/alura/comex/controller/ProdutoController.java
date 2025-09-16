package br.com.alura.comex.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.dto.DadosCadastrarProduto;
import br.com.alura.comex.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping()
    @Transactional
    public void cadastrarProduto(@Valid @RequestBody DadosCadastrarProduto dados) {
        produtoService.cadastrarProduto(dados);
    }
}
