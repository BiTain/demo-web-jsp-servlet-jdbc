package com.demoweb.dao.impl;

import java.util.List;

import com.demoweb.dao.IUserDAO;
import com.demoweb.mapper.UserMapper;
import com.demoweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPassWord(String userName, String passWord) {
		StringBuilder sql = new StringBuilder("select * from users as u ");
		sql.append(" inner join role as r on r.id = u.roleid");
		sql.append(" where username = ? and password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName,passWord);
		return users.isEmpty() ? null : users.get(0);
	}

}
