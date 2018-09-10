package com.testuser.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.testuser.template.util.DBConnector;
import com.testuser.template.util.DateUtil;

public class UserCreateCompleteDAO {

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO login_user_trabsaction(login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";

	public void createUser(String loginUserId,String loginUserPassword,String userName) throws
	SQLException{
		DBConnector dbConnector = new DBConnector();

		Connection connection = dbConnector.getConnection();

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2,loginUserPassword);
			preparedStatement.setString(3,userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
