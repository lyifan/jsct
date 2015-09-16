package com.wcg.training.web;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class BaseController {
	
	protected Connection getConnection() throws Exception {
		Context initialContext = new InitialContext();
		
		DataSource datasource = (DataSource)initialContext.lookup("java:comp/env/jdbc/trainingDB");
		
		return datasource.getConnection();
	}

	@RequestMapping(method=RequestMethod.GET)
	public void index(Model model) {
		
	}
}
