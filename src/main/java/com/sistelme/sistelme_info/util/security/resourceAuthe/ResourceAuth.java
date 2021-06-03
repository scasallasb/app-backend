package com.sistelme.sistelme_info.util.security.resourceAuthe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistelme.sistelme_info.util.MyUserDetailsService;
import com.sistelme.sistelme_info.util.security.model.Request;
import com.sistelme.sistelme_info.util.security.model.Response;
import com.sistelme.sistelme_info.util.security.util.JwtUtil;

@RestController
public class ResourceAuth {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;


	
  @RequestMapping(value="/authenticate",method= RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody Request authenticationRequest) throws Exception {
	  
	  try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUser(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUser());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new Response(jwt));
	}
  }
  
  

