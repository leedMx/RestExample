package com.example.restExcercise.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AuthenticationService implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        Object principal = auth.getPrincipal();
        Object credentials = auth.getCredentials();
        return ("admin".equalsIgnoreCase(String.valueOf(principal)) &&
                "password".equals(String.valueOf(credentials)) ||
                credentials == null) ?
                new UsernamePasswordAuthenticationToken(principal, credentials):
                null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
