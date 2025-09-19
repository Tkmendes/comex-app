package br.com.alura.comex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.dto.DadosCadastrarCategoria;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastrarCategoria dados) {
        categoriaService.cadastrarCategoria(dados);
    }

    @GetMapping
    public List<Categoria> listarTodasCategorias() {
        return categoriaService.listarTodasCategorias();
    }

}
