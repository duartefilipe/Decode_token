package com.token.token.controller;

import com.token.token.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    // 1. Receber pelo Header Authorization
    @GetMapping("/decode")
    public ResponseEntity<Map<String, Object>> decodeTokenFromHeader(@RequestHeader("Authorization") String token) {
        return decode(token);
    }

    // 2. Receber como Query Param
    @GetMapping("/decode-param")
    public ResponseEntity<Map<String, Object>> decodeTokenFromParam(@RequestParam("token") String token) {
        return decode(token);
    }

    // 3. Receber no corpo da requisição (POST)
    public static class TokenRequest {
        public String token;
    }

    @PostMapping("/decode-body")
    public ResponseEntity<Map<String, Object>> decodeTokenFromBody(@RequestBody TokenRequest tokenRequest) {
        return decode(tokenRequest.token);
    }

    // Método centralizado de decodificação
    private ResponseEntity<Map<String, Object>> decode(String token) {
        try {
            Map<String, Object> decodedData = tokenService.decodeToken(token);
            return ResponseEntity.ok(decodedData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Token inválido: " + e.getMessage()));
        }
    }
}
