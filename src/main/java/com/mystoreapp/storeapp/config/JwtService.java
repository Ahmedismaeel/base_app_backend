package com.mystoreapp.storeapp.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    private Key getSingingKey(

    ){
        String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
        public String extractUsername(String token){
            return getClaim(token,Claims::getSubject);
        }


public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
}
public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){

    return  Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+86400000))
            .signWith(getSingingKey())
            .compact();


}

public boolean isValidToken(String token,UserDetails userDetails){

        String username = extractUsername(token);

        return  (username.equals(userDetails.getUsername()) && !isTokenExpire(token));

}

    private boolean isTokenExpire(String token) {
    Date date =    extractExpiration(token);
        logger.info(date.toString());
    return extractExpiration(token).before(new Date());
    }

    private Date   extractExpiration(String token) {
    return getClaim(token,Claims::getExpiration);
    }


    public <T> T getClaim(String token , Function<Claims,T> claimsResolver){

    Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
}
private Claims getAllClaims(String token ){
    return Jwts.parserBuilder()
            .setSigningKey(getSingingKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
}


}
