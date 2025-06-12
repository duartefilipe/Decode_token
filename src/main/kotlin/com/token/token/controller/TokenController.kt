package com.token.token.controller 

import com.token.token.service.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TokenController(private val tokenService: TokenService) {

    @GetMapping("/decode")
    fun decodeToken(@RequestHeader("Authorization") token: String): ResponseEntity<Map<String, Any>> { 
        return try {
            val decodedData = tokenService.decodeToken(token)
            ResponseEntity.ok(decodedData)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}