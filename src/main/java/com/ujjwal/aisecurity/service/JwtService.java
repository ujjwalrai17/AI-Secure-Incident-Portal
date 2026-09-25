//package com.ujjwal.aisecurity.security;
//import java.nio.charset.StandardCharsets;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.stream.DoubleStream;
//
//@Service
//public class JwtService {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private long expiration;
//
//    private SecretKey getKey() {
//        //return Keys.hmacShaKeyFor(secret.getBytes());
//        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//    }
//
//    public boolean isTokenValid(String token, String username) {
//        return extractUsername(token).equals(username);
//    }
//
//    public String generateToken(String username) {
//
//
//        return Jwts.builder()
//                .subject(username)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getKey())
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//
////        return Jwts.parser()
////                .verifyWith(getKey())
////                .build()
////                .parseSignedClaims(token)
////                .getPayload()
////                .getSubject();
//
//        try {
//            return Jwts.parser()
//                    .verifyWith(getKey())
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload()
//                    .getSubject();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//}


package com.ujjwal.aisecurity.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey())
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}