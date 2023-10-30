package com.example.demo.controllers

import com.example.demo.DTO.CadastroDTO
import com.example.demo.DTO.LoginDTO
import com.example.demo.entities.Usuario
import com.example.demo.repositories.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthenticationController(
    val authenticationManager: AuthenticationManager,
    var usuarioRepository: UsuarioRepository
) {

    @PostMapping("/login")
    fun login(@RequestBody login: LoginDTO): Any {
        val userPassword = UsernamePasswordAuthenticationToken(login.usuario, login.senha)
        val auth = this.authenticationManager.authenticate(userPassword)

        return "Usuário logado!"
    }

    @PostMapping("/register")
    fun singUp(@RequestBody cadastro: CadastroDTO): Any {
        if(usuarioRepository.findByEmail(cadastro.email) != null) error("E-mail já cadastrado!")

        val senha = BCryptPasswordEncoder().encode(cadastro.senha)
        val user = Usuario().toUsuarioCadastro(cadastro, senha)

        return usuarioRepository.save(user).toUsuarioRetorno()
    }
}