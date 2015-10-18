package com.wcg.trainning.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String loginName = String.valueOf(authentication.getPrincipal());
		String[] credentials = (String[])authentication.getCredentials();
		try {
			this.verifyLoginnamePassword(loginName, credentials[0]);
		
			this.verifyOTP(credentials[1]);
			
		} catch(OTPException | LoginnamePasswordException e) {
			
			throw new InsufficientAuthenticationException(e.getMessage(), e);
		}
	
		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(MyAuthentication.class);
		
	}
	
	private void verifyLoginnamePassword(String loginName, String password) throws LoginnamePasswordException {
		// get user info from database and verify
	}
	
	private void verifyOTP(String otp) throws OTPException {
		// otpVerificationService.verify(otp);
	}

}
