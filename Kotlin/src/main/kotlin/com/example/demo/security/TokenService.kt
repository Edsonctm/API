package com.example.demo.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.example.demo.entities.Usuario
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService(
    @Value("${'$'}{api.security.token.secret}")
    private val secret: String
) {

    fun generateToken(user: Usuario): String{
        try {
            val algorithm = Algorithm.HMAC256(secret)
            return JWT.create()
                .withIssuer("demo-api")
                .withSubject(user.email)
                .withExpiresAt(tokenExpiration())
                .sign(algorithm)
        } catch(e: JWTCreationException){
            throw RuntimeException("Erro ao gerar token", e)
        }
    }

    fun validateToken(token: String): String {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("demo-api")
                .build()
                .verify(token)
                .subject
        } catch(e: JWTVerificationException) {
            ""
        }

    }

    private fun tokenExpiration(): Instant {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"))
    }
}