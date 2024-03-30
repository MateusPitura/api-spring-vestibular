package br.com.mateus.api.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import br.com.mateus.api.users.Users;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String API_KEY;

    public String createToken(Users users){
        try{
            Algorithm algorithm = Algorithm.HMAC256(API_KEY);
            return JWT.create()
            .withIssuer("API vestibulares")
            .withSubject(users.getUsername())
            .withExpiresAt(defineExpiresTime())
            .sign(algorithm);
        } catch(JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    private Instant defineExpiresTime(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(API_KEY);
            return JWT.require(algorithm)
            .withIssuer("API vestibulares")
            .build()
            .verify(token)
            .getSubject();
        } catch(JWTCreationException e){
            throw new RuntimeException("Erro ao validar token", e);
        }
    }
}
