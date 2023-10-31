package com.example.demo.services

import com.example.demo.repositories.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    private val usuarioRepository: UsuarioRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) error("Informe o usuário!")
        return usuarioRepository.findByEmail(username)?: error("Usuário não encontrado!")
    }
}
