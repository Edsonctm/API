package com.example.demo.entities

import com.example.demo.DTO.UsuarioRetorno
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "usuarios")
class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotNull("O nome é obrigatório!")
    val nome: String,

    @NotNull("O email é obrigatório!")
    val email: String,

    @NotNull("A senha é obrigatória!")
    val senha: String

){
    fun toUsuarioRetorno(): UsuarioRetorno{
        return UsuarioRetorno(
            id = id,
            nome = nome,
            email = email
        )
    }
}