package com.nissum.user.controller;

import com.nissum.user.domain.UserDto;
import com.nissum.user.domain.UserRsDto;
import com.nissum.user.service.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.hibernate.IdentifierLoadAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SaveUserController {


    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UserRsDto addUser(@RequestBody UserDto request){
        UserRsDto response = iUserService.save(request);
        String token = getJWTToken(request.getEmail());
        response.setToken(token);
        response.setIsactive(true);
        return response;
    }

    @GetMapping("find/{id}")
    public UserDto findUser(@PathVariable Long id){
        return iUserService.getUser(id);
    }


    private String getJWTToken(String email) {
        String secretKey = "nissumtest";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("nissumJWT")
                .setSubject(email)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
