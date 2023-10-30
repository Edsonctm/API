package com.example.demo.repositories

import com.example.demo.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByEmail(email: String): UserDetails?
}