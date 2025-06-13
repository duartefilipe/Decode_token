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

    @GetMapping("/decode")
    public ResponseEntity<Map<String, Object>> decodeToken(@RequestHeader("Authorization") String token) {
        try {
            Map<String, Object> decodedData = tokenService.decodeToken(token);
            return ResponseEntity.ok(decodedData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
