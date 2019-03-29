package com.evilcorp.evilfridge.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenProvider {

  private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
  private final String secretKey;
  private final long tokenExpiration;

  public TokenProvider() {
    this.secretKey = System.getenv("FRIDGEDOOR_SECRETKEY");
    this.tokenExpiration = 86400000;
  }

  public String createToken(Authentication authentication) {
    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + tokenExpiration);

    return Jwts.builder()
        .claim("ID", userPrincipal.getId())
        .claim("name", userPrincipal.getName())
        .setSubject(userPrincipal.getEmail())
        .setIssuedAt(new Date())
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public Long getUserIdFromToken(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getBody();
    return Long.parseLong(claims.getId());
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException ex) {
      logger.error("Invalid JWT signature");
    } catch (MalformedJwtException ex) {
      logger.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      logger.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      logger.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      logger.error("JWT claims string is empty.");
    }
    return false;
  }
}
