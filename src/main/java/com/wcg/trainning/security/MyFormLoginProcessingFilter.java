package com.wcg.trainning.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class MyFormLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {
	
	protected MyFormLoginProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String otp = request.getParameter("otp");
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				
		Authentication auth = new MyAuthentication(loginName, new String[] {password, otp}, roles);
		
		getAuthenticationManager().authenticate(auth);
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
        return auth;
	}

}
