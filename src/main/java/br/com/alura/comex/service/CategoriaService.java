package br.com.alura.comex.service;

import org.springframework.stereotype.Service;

import br.com.alura.comex.dto.DadosCadastrarCategoria;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void cadastrarCategoria(DadosCadastrarCategoria dados) {
        Categoria categoria = new Categoria();
        categoria.setNome(dados.nome());
        categoria.setStatus(true);

        categoriaRepository.findByNome(dados.nome()).ifPresentOrElse(
                categoriaExistente -> {
                    // Lógica se a categoria já existe
                    if (categoriaExistente.isStatus()) {
                        throw new RuntimeException("Categoria já cadastrada");
                    } else {
                        throw new RuntimeException(
                                "Categoria já cadastrada e inativa, favor editar categoria existente");
                    }
                },
                () -> {
                    // Lógica se a categoria não existe: cria uma nova.
                    categoriaRepository.save(categoria);
                });
    }

}
