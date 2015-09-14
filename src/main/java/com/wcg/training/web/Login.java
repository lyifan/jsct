package com.wcg.training.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//TODO: USE SpringMVC + AngularJS

public abstract class Login extends BaseController {

	private String hashPassword(char[] password) {
		return new String(password);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPrivilegeAction(@RequestParam("loginName") String username, @RequestParam("password") char[] password, Model model)
			throws Exception {
		Connection connection = getConnection();
		if (connection == null) {
			// Handle error
		}
		try {
			String pwd = hashPassword(password);

			PreparedStatement stmt = this.generateStatement(connection, username, pwd);

			ResultSet rs = stmt.executeQuery();
			
			boolean success = rs.next();
			
			model.addAttribute("result", success ? "You've logged in" : "User name or password incorrect");
			model.addAttribute("resultColor", success ? "green" : "red");

		} finally {
			try {
				connection.close();
			} catch (SQLException x) {
				// Forward to handler
			}
		}
	}
	
	protected abstract PreparedStatement generateStatement(Connection connection, String username, String pwd) throws SQLException;

}