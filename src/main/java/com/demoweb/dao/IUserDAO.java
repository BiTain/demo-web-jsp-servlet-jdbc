package com.demoweb.dao;

import com.demoweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findByUserNameAndPassWord(String userName, String passWord);
}
