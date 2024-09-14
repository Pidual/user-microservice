package com.emazon.usermicroservice.infrastructure.security.service;

import com.emazon.usermicroservice.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import static com.emazon.usermicroservice.common.Constants.*;

@Service
public class JwtService {



    // Usamos una clave secreta más segura, codificada en base64
    private String SECRET_KEY = "7OCOuld01GpRMRt3J9KWw1hGcvKTtcbxxfvLNx8JF+g=";  // Base64 encoded key

    // Método para generar el token
    public String generateToken(User user, Map<String, Object> extraClaims) {

        extraClaims.put("role", user.getRole().getRoleName());
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + EXPIRATION_MINUTES * EXPIRATION_HOURS * EXPIRATION_MILLISECONDS);

        return Jwts.builder().setClaims(extraClaims)
                .setSubject(user.getEmail())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)  // Usamos getSigningKey()
                .compact();
    }

    // Método para obtener la clave de firma desde la cadena Base64
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);  // Decodifica la clave en Base64
        return Keys.hmacShaKeyFor(keyBytes);  // Usa la clave decodificada para HMAC-SHA256
    }

    // Extraer el "username" o "subject" del token JWT
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extraer cualquier "claim" del JWT
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Método actualizado para extraer todos los "claims"
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())  // Usa el nuevo método para la clave de firma
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validar el token JWT comparando el username con el de UserDetails
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Verificar si el token ha expirado
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Obtener la fecha de expiración del token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
