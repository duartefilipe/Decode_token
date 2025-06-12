package com.token.token.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenService {

    private val logger = LoggerFactory.getLogger(TokenService::class.java)

    fun decodeToken(bearerToken: String): Map<String, Any> {
        logger.info("--- Iniciando processo de decodificação de token ---")
        val jwt = bearerToken.substringAfter("Bearer ").trim()

        val claims = getClaims(jwt)
        logger.info("Claims extraídas com sucesso. Retornando o mapa completo.")

        return claims
    }

    private fun getClaims(jwt: String): Claims {
        val chunks = jwt.split(".")
        if (chunks.size < 2) {
            throw IllegalArgumentException("Token JWT mal formatado.")
        }

        val payloadJson = String(Base64.getUrlDecoder().decode(chunks[1]))

        val claimsMap: Map<String, Any> = Gson().fromJson(payloadJson, object : TypeToken<Map<String, Any>>() {}.type)

        return Jwts.claims(claimsMap)
    }
}