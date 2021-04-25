package com.example.ztpai.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

import static io.jsonwebtoken.Jwts.parser;

@Service
public class Jwt {

    private final String publicKey = "ztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpai";

    public String generateToken(Authentication authentication){
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        long now = System.currentTimeMillis();
        String privateKey = "ztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpaiztpaiztpaiztpai123ztpai";
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 700000000))
                .signWith(Keys.hmacShaKeyFor(privateKey.getBytes()))
                .compact();
    }

    public String getUsernameFromJwt(String jwtToken){
        return parser()
                .setSigningKey(Keys.hmacShaKeyFor(publicKey.getBytes()))
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String jwtToken) {
        try{
            parser().setSigningKey(Keys.hmacShaKeyFor(publicKey.getBytes())).parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
