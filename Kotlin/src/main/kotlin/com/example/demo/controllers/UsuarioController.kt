package com.example.demo.controllers

import com.example.demo.entities.Usuario
import com.example.demo.repositories.UsuarioRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.HttpRetryException

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val usuarioRepository: UsuarioRepository
)  {

    @GetMapping
    fun todosUsuarios(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    @PostMapping
    fun criarUsuario(@RequestBody usuario: Usuario): Any {
        check(usuarioRepository.findByEmail(usuario.email) == null){
            error("E-mail já cadastrado!")
        }
        return usuarioRepository.save(usuario)
    }

    @PutMapping
    fun alterarUsuario(@RequestBody newUser: Usuario): Usuario {
        return usuarioRepository.save(newUser)
    }

    @DeleteMapping("/{id}")
    fun deletarUsuario(@PathVariable id: Long): Any {
        return usuarioRepository.deleteById(id)
    }
}