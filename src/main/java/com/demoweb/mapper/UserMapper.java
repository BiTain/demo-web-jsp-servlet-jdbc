package com.demoweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.demoweb.model.RoleModel;
import com.demoweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel users = new UserModel();
			users.setId(rs.getLong("id"));
			users.setUserName(rs.getString("username"));
			users.setPassWord(rs.getString("password"));
			users.setFullName(rs.getString("fullname"));
			users.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			users.setRoleId(rs.getLong("roleid"));
			users.setCreatedDate(rs.getDate("createddate"));
			users.setCreatedBy(rs.getString("createdby"));
			if(rs.getDate("modifieddate") != null) {
				users.setModifiedDate(rs.getDate("modifieddate"));
			}
			if(rs.getString("modifiedby") != null) {
				users.setModifiedBy(rs.getString("modifiedby"));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
