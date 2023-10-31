package com.example.demo.entities

import com.example.demo.dto.CadastroDTO
import com.example.demo.dto.UsuarioRetorno
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "usuarios")
class Usuario : UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotNull("O nome é obrigatório!")
    var nome: String = ""

    @NotNull("O email é obrigatório!")
    var email: String = ""

    @NotNull("A senha é obrigatória!")
    var senha: String = ""

    var role: UsuarioRoles = UsuarioRoles.USER

    fun toUsuarioRetorno(): UsuarioRetorno{
        return UsuarioRetorno(
            id = id,
            nome = nome,
            email = email
        )
    }

    fun toUsuarioCadastro(cadastro: CadastroDTO, senhaEncoded: String): Usuario{
        val user = Usuario()
        user.nome = cadastro.nome
        user.email = cadastro.email
        user.senha = senhaEncoded
        return user
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return if(this.role == UsuarioRoles.ADMIN) mutableListOf(SimpleGrantedAuthority("ROLE_ADMIN"),
            SimpleGrantedAuthority("ROLE_USER"))
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))

    }

    override fun getPassword(): String {
        return senha
    }

    override fun getUsername(): String {
        return nome
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
