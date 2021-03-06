package com.demoapp.ptg.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.ptg.models.User;
import com.demoapp.ptg.repositories.UserRepository;
import com.demoapp.ptg.security.Credentials;
import com.demoapp.ptg.security.JwtTokenUtil;
import com.demoapp.ptg.security.JwtUser;
import com.demoapp.ptg.security.Token;
import com.demoapp.ptg.validators.CredentialsValidator;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	CredentialsValidator credentialsValidator;
	
	@Override
	public Token generateToken(User user) {
		
		String token = jwtTokenUtil.doGenerateToken(new JwtUser(user));
		
		// Get login date from the token which was just generated
		Date userLastLogin = jwtTokenUtil.getUserFromToken(token).getLast_login();
		// Then update user last login date
		user.setLast_login(userLastLogin);
		userRepository.save(user);
		
		return new Token(token);
	}

	@Override
	public Token authenticate(Credentials credentials) throws Exception {
		
		credentialsValidator.validate(credentials);
		
		User user = userRepository.findByEmail(credentials.getEmail());
		
		return this.generateToken(user);
	}

}
