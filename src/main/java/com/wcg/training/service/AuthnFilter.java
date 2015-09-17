package com.wcg.training.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthnFilter implements Filter {

	private FilterConfig filterConfig;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException,
			ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		if(filterConfig.getInitParameter("protected").contains(request.getServletPath()) && request.getSession().getAttribute("USER") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		if(request.getServletPath().startsWith("/logoff")) {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		response.addIntHeader("X-XSS-Protection", 0);
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
