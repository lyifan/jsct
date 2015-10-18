package com.wcg.trainning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.wcg.training.domain.User;
import com.wcg.training.service.UserService;

public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService _userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String loginName = String.valueOf(authentication.getPrincipal());
		String[] credentials = (String[])authentication.getCredentials();
		try {
			User user = this.findUser(loginName, credentials[0]);
		
			this.verifyOTP(credentials[1]);
			
			((MyAuthentication)authentication).setUser(user);
			
		} catch(OTPException | UserNotFoundException e) {
			
			throw new InsufficientAuthenticationException(e.getMessage(), e);
		}
	
		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(MyAuthentication.class);
		
	}
	
	private User findUser(String loginName, String password) throws UserNotFoundException {

		User user = _userService.findUser(loginName, password);
		if(user == null) {
			throw new UserNotFoundException();
		}
		
		return user;		
	}
	
	private void verifyOTP(String otp) throws OTPException {
		// otpVerificationService.verify(otp);
	}

}
