package com.demoapp.ptg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.ptg.validators.TokenValidator;


@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	TokenValidator tokenValidator;
	
	@Override
	public void authorize(String token) throws Exception {
		tokenValidator.validate(token);
	}

}
