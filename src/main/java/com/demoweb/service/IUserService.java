package com.demoweb.service;

import com.demoweb.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPassWord(String userName,String passWord);
}
