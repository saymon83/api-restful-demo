package com.demoapp.ptg.restcontrollers;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.ptg.models.User;
import com.demoapp.ptg.security.Credentials;
import com.demoapp.ptg.security.Token;
import com.demoapp.ptg.services.AuthenticationService;
import com.demoapp.ptg.services.UserService;


@RestController
@RequestMapping(value = "/")
public class AuthenticationRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	Validator validator;
		
	@PostMapping("/signup")
	private ResponseEntity<Object> signup(@RequestBody User user) throws Exception {
		
		userService.save(user);
		
		Token token = authenticationService.generateToken(user);
		
		return ResponseEntity.ok().body(token);
	}
	
	@PostMapping("/signin")
	private ResponseEntity<Object> signin(@RequestBody Credentials credentials) throws Exception {
				
		Token token = authenticationService.authenticate(credentials);
		
		return ResponseEntity.ok().body(token);
	}

}
