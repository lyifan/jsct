package com.wcg.training.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unsafelogin")
public class UnsafeLogin extends Login {
	
	@Override
	protected PreparedStatement generateStatement(Connection connection, String username, String pwd)
			throws SQLException {
		String sqlString = "select * from TblUser where LoginName = '" + username + "' and Password ='" + pwd + "'";
		return connection.prepareStatement(sqlString);
	}
}
