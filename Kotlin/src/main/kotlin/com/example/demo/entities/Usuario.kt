package com.example.demo.entities

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

)