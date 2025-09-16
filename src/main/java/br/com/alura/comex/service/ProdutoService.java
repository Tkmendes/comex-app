package br.com.alura.comex.service;

import java.util.Optional;

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

        Optional<Produto> optionalProduto = produtoRepository.findByNome(dados.nome());

        if (optionalProduto.isPresent()) {
            // Se o produto já existe, vamos atualizá-lo.
            Produto produtoExistente = optionalProduto.get();
            if (produtoExistente.getCategorias().contains(categoria)) {
                // Se a categoria já está associada, lançamos a exceção esperada.
                throw new RuntimeException("Produto já cadastrado nessa categoria.");
            }
            // Se não, adiciona a nova categoria ao produto existente.
            produtoExistente.adicionaCategoria(categoria);
        } else {
            // Se o produto não existe, criamos um novo.
            Produto produtoNovo = new Produto(dados);
            produtoNovo.adicionaCategoria(categoria);
            produtoRepository.save(produtoNovo);
        }
    }
}
