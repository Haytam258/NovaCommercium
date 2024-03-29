package com.novacommercium.nova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
