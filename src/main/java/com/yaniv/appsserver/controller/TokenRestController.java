package com.yaniv.appsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yaniv.appsserver.entity.Token;
import com.yaniv.appsserver.service.TokenService;

@RestController
public class TokenRestController {

	@Autowired
	private TokenService tokenService;

	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@PostMapping("/api/token")
	public void saveToken(@RequestBody Token token) {
		System.out.println(token.toString());
		tokenService.saveToken(token);

		System.out.println("Token Saved Successfully");
	}

}