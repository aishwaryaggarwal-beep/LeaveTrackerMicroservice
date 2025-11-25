package com.example.demo.Service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	 @Value("${jwt.secret}")
	    private String secretKey;

	    private Key getSignKey() {
	        return Keys.hmacShaKeyFor(secretKey.getBytes());
	    }

//	public JwtService() {
//		secretKey = generateKey();
//	}
//	private String generateKey() {
//		try {
//			KeyGenerator keyg =  KeyGenerator.getInstance("HmacSHA256");
//			SecretKey secretkey = keyg.generateKey();
//			return Base64.getEncoder().encodeToString(secretkey.getEncoded());
//		}
//		catch(NoSuchAlgorithmException  e) {
//			throw new RuntimeException("error generating secret key",e);
//		}
//		
//	}

//	public String generateToken(UserDetails userDetails) {
//	    Map<String,Object> claims = new HashMap<>();
//	    String role = userDetails.getAuthorities().iterator().next().getAuthority();
//	    claims.put("role", role);
//
//	    return Jwts.builder()
//	            .setClaims(claims)
//	            .setSubject(userDetails.getUsername())
//	            .setIssuedAt(new Date(System.currentTimeMillis()))
//	            .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
//	            .signWith(getSignKey(), SignatureAlgorithm.HS256)
//	            .compact();
//	}
	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();

	        // Store all roles in the token
	        List<String> roles = userDetails.getAuthorities()
	                .stream()
	                .map(a -> a.getAuthority())
	                .toList();
	        claims.put("roles", roles);

	        return Jwts.builder()
	                .setClaims(claims)
	                .setSubject(userDetails.getUsername())
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
	                .signWith(getSignKey(), SignatureAlgorithm.HS256)
	                .compact();
	    }

	
//	private Key getKey() {
//		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//		return Keys.hmacShaKeyFor(keyBytes);
//	}
	
	public String extractRole(String token) {
	    return extractClaim(token, claims -> claims.get("role", String.class));
	}

	public String extractUserName(String token) {
		 return extractClaim(token,Claims::getSubject);
	}
	private <T> T extractClaim(String token,Function<Claims,T> claimResolver) {
	       final Claims claims = extractAllClaims(token);
	       return claimResolver.apply(claims);
	}
	public Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
		
	}
	private java.util.Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token,Claims::getExpiration);
	}
}
