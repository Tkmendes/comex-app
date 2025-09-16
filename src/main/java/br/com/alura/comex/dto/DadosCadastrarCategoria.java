package br.com.alura.comex.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastrarCategoria(
        @NotBlank @Pattern(regexp = "^[A-Za-z0-9 ]{2,}$", message = "Nome deve ter pelo menos 2 caracteres alfanuméricos.") String nome) {

}
