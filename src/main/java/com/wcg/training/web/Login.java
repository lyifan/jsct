package com.wcg.training.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//TODO: USE SpringMVC + AngularJS

@Controller
@RequestMapping("/login")
public class Login extends BaseController {

	private String hashPassword(char[] password) {
		return new String(password);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPrivilegeAction(@RequestParam("loginName") String username, @RequestParam("password") char[] password, Model model, HttpSession session)
			throws Exception {
		Connection connection = getConnection();
		try {
			String pwd = hashPassword(password);

			PreparedStatement stmt = this.generateStatement(connection, username, pwd);

			ResultSet rs = stmt.executeQuery();
			
			boolean success = rs.next();
			
			return this.checkResult(success, model, session, username);
			
		} finally {
			try {
				connection.close();
			} catch (SQLException x) {
			}
		}
	}
	
	private String checkResult(boolean success, Model model, HttpSession session, String username) {
		if(!success) {
			model.addAttribute("result", "User name or password incorrect");
			model.addAttribute("resultColor", "red");
	
			return "/login";
		}
		
		session.setAttribute("USER", username);
		
		return "redirect:/home";		
	}
	
/*	private PreparedStatement generateStatement(Connection connection, String username, String pwd)
			throws SQLException {
		
		String sqlString = "select * from TblUser where LoginName = ? and Password = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sqlString);
		
		stmt.setString(1, username);
		stmt.setString(2, pwd);

		return stmt;
	}*/
	
	private PreparedStatement generateStatement(Connection connection, String username, String pwd)
			throws SQLException {
		String sqlString = "select * from TblUser where LoginName = '" + username + "' and Password ='" + pwd + "'";
		return connection.prepareStatement(sqlString);
	}	
}