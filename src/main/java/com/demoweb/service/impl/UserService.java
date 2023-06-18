package com.demoweb.service.impl;

import javax.inject.Inject;

import com.demoweb.dao.IUserDAO;
import com.demoweb.model.UserModel;
import com.demoweb.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;
	@Override
	public UserModel findByUserNameAndPassWord(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userDAO.findByUserNameAndPassWord(userName, passWord);
	}

}
