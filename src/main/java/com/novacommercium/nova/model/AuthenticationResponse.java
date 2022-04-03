package com.novacommercium.nova.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class AuthenticationResponse {

    private final String jwt;


}
