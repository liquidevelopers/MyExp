package com.yaniv.appsserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaniv.appsserver.entity.Token;
import com.yaniv.appsserver.repository.TokenRepository;
import com.yaniv.appsserver.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public void setTokenRepository(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}


	@Override
	public void saveToken(Token token) {
		tokenRepository.save(token);
		
	}
}