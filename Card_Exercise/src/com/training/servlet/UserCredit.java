package com.training.servlet;
import java.util.Map;
import java.util.HashMap;

public class UserCredit {
	
	private Map<String,Integer> user;

	public UserCredit() {
		super();
		this.user = new HashMap<String,Integer>();
		
		this.user.put("ani", 2000);
		this.user.put("xyz", 3000);
		this.user.put("pqr", 2000);
	}

	public Map<String, Integer> getUser() {
		return user;
	}
	
	
	

}
