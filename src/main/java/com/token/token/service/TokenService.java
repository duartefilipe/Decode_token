package com.token.token.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Service
public class TokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public Map<String, Object> decodeToken(String bearerToken) {
        logger.info("--- Iniciando processo de decodificação de token ---");
        String jwt = bearerToken.replaceFirst("(?i)^Bearer ", "").trim();

        Claims claims = getClaims(jwt);
        logger.info("Claims extraídas com sucesso. Retornando o mapa completo.");
        return claims;
    }

    private Claims getClaims(String jwt) {
        String[] chunks = jwt.split("\\.");
        if (chunks.length < 2) {
            throw new IllegalArgumentException("Token JWT mal formatado.");
        }

        String payloadJson = new String(Base64.getUrlDecoder().decode(chunks[1]), StandardCharsets.UTF_8);

        Map<String, Object> claimsMap = new Gson().fromJson(payloadJson, new TypeToken<Map<String, Object>>() {}.getType());

        return Jwts.claims(claimsMap);
    }
}
