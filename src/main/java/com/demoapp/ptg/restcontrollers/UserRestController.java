package com.demoapp.ptg.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.ptg.security.JwtTokenUtil;
import com.demoapp.ptg.security.JwtUser;
import com.demoapp.ptg.services.AuthorizationService;


@RestController
@RequestMapping(value = "/")
public class UserRestController {
	
	@Value("${jwt.header.authorization}")
    private String authorization;

	@Autowired
	AuthorizationService authorizationService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/me")
	private ResponseEntity<Object> me(HttpServletRequest request) 
			throws Exception {

		String token = request.getHeader(authorization);
		
		authorizationService.authorize(token);
		
		JwtUser jwtUser = jwtTokenUtil.getUserFromToken(token);
		
		return ResponseEntity.ok().body(jwtUser);
	}

}
