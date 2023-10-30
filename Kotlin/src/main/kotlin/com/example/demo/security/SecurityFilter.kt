package com.example.demo.security

import com.example.demo.repositories.UsuarioRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(
    private val tokenService: TokenService,
    private val usuarioRepository: UsuarioRepository
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = this.recoverToken(request)
        val email = tokenService.validateToken(token)
        val user = usuarioRepository.findByEmail(email)?: return filterChain.doFilter(request, response)

        val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
        SecurityContextHolder.getContext().authentication = authentication
        filterChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String {
        val authHeader = request.getHeader("Authorization") ?: return ""
        return authHeader.replace("Bearer ", "")


    }
}