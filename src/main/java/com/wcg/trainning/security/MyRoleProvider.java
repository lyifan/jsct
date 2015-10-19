package com.wcg.trainning.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MyRoleProvider {

	@Autowired
	private HttpServletRequest request;
	
	public String getRolesByUrl() {
		
		System.out.println("Requesting: " + this.request.getRequestURI());
		
		return "hasRole('ROLE_ADMIN')";
	}
	
	@SuppressWarnings("unused")
	private String getRequestUrl() {
		return 
				((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest().getRequestURI();
	}
	
}
