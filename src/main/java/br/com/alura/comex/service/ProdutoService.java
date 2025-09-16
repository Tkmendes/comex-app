package br.com.alura.comex.service;

import org.springframework.stereotype.Service;

import br.com.alura.comex.dto.DadosCadastrarProduto;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void cadastrarProduto(DadosCadastrarProduto dados) {
        Categoria categoria = categoriaRepository.findByNome(dados.categoria())
                .orElseGet(() -> {
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(dados.categoria());
                    novaCategoria.setStatus(true);
                    return categoriaRepository.save(novaCategoria);
                });

        Produto produto = new Produto(dados);
        produto.adicionaCategoria(categoria);

        produtoRepository.save(produto);
    }
}
