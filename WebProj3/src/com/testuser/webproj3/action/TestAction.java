package com.testuser.webproj3.action;

import com.opensymphony.xwork2.ActionSupport;
import com.testuser.webproj3.dao.TestDAO;

public class TestAction extends ActionSupport{

	private String username;

	private String password;

	public String execute(){
		String ret = ERROR;
		TestDAO dao = new TestDAO();
		int count=dao.insert(username,password);
		if(count>0){
			ret=SUCCESS;
		}
		return ret;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

}
