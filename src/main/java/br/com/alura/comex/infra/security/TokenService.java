package br.com.alura.comex.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.alura.comex.model.Usuario;

@Service
public class TokenService {

    private final String secret = "mySecret";

    public String gerarToken(Usuario usuario) {
        try {
            return JWT.create()
                    .withIssuer("API Comex")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token jwt", e);
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Comex")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }
}
