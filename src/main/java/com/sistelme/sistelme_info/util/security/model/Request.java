package com.sistelme.sistelme_info.util.security.model;

import lombok.Data;

@Data
public class Request {
	
	private String  user;
	private String password;
	public Request() {
		
	}
	
	public Request(String user, String password){
		this.user= user;
		this.password= password;
		
	}
	
}
