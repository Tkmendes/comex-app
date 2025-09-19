package br.com.alura.comex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCliente(
                @NotBlank String nome,
                @NotBlank @Email(message = "E-mail inválido") String email,
                @NotBlank String senha,
                @NotBlank String telefone,
                @NotBlank String cpf,
                @NotBlank String logradouro,
                @NotBlank String bairro,
                @NotBlank String cidade,
                @NotBlank String uf,
                @NotBlank String cep) {
}
