package com.token.token.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${app.backend.base-url}")
    private String backendUrl;

    @GetMapping("/backend-url")
    public Map<String, String> getBackendUrl() {
        return Collections.singletonMap("url", backendUrl);
    }
}
