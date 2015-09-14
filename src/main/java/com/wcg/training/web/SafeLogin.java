package com.wcg.training.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/safelogin")
public class SafeLogin extends Login {

	@Override
	protected PreparedStatement generateStatement(Connection connection, String username, String pwd)
			throws SQLException {
		
		String sqlString = "select * from TblUser where LoginName = ? and Password = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sqlString);
		
		stmt.setString(1, username);
		stmt.setString(2, pwd);

		return stmt;
	}

}
