package com.demoapp.ptg.services;

import com.demoapp.ptg.models.User;
import com.demoapp.ptg.security.Credentials;
import com.demoapp.ptg.security.Token;


public interface AuthenticationService {
	
	public Token generateToken(User user);
	
	public Token authenticate(Credentials credentials) throws Exception;

}
