package com.luv2code.springdemo.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.AuthRequest;
import com.luv2code.springdemo.util.JwtUtil;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private Logger logger = Logger.getLogger(getClass().getName()); 
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome!!!";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		logger.info(authRequest.toString());
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid username/password");
		}
		
		return jwtutil.generateToken(authRequest.getUsername());
	}

}







