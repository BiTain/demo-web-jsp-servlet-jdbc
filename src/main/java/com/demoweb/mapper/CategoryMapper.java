package com.demoweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.demoweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			long id;
			id = rs.getInt("id");
			String code = rs.getString("code");
			String name = rs.getString("name");
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(id);
			categoryModel.setCode(code);
			categoryModel.setName(name);
			return categoryModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
