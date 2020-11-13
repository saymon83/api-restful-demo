package com.demoapp.ptg.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class HomeRestController {
	
	@GetMapping
	private ResponseEntity<Object> home() {
		return ResponseEntity.ok().body("API RESTful for user authentication and registr. More details at: <a target='_blank' href='https://github.com/saymon83/api-restful-demo'>https://github.com/saymon83/api-restful-demo<a>");
	}

}
