package com.testuser.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.testuser.webproj4.dao.TestDAO;
import com.testuser.webproj4.dto.LoginDTO;

public class TestAction extends ActionSupport{

	private String username;

	private String password;

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute(){
		String ret = ERROR;

		TestDAO dao = new TestDAO();
		int count = dao.insert(username, password);

		if(count > 0){
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}

		loginDTOList =dao.select(username, password);
		return ret;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public List<LoginDTO> getLoginDTOList(){
		return loginDTOList;
	}

	public void setLoginDTOList(List<LoginDTO> loginDTOList){
		this.loginDTOList = loginDTOList;
	}

}
