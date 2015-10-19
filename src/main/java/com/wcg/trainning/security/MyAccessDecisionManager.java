package com.wcg.trainning.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

public class MyAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if(!(authentication instanceof MyAuthentication)) {
			throw new AccessDeniedException("Access denied");
		}
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(@SuppressWarnings("unused") GrantedAuthority authority : authorities) {
			((FilterInvocation)object).getRequestUrl();
		}
		
		System.out.println(object);
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
