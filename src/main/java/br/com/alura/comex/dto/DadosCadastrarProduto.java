package br.com.alura.comex.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record DadosCadastrarProduto(
                @NotBlank @Pattern(regexp = "^[A-Za-zÀ-ú ]{2,}$", message = "Nome deve ter pelo menos 2 caracteres alfanuméricos.") String nome,
                String descricao,
                @NotNull @Positive(message = "O preço deve ser um valor positivo") double preco,
                @NotNull Integer quantidade,
                @NotBlank String categoria) {
}
