package br.com.alura.comex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank @Email(message = "Login inválido") String login,
        @NotBlank String senha) {
}
