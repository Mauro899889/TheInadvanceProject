package com.test.inadvance.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JwtUtil {
	
	private String secret = "inadvance123";

    public String generateToken(String mail) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, mail);
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}
