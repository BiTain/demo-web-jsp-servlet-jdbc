package com.demoweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demoweb.dao.ICategoryDAO;
import com.demoweb.mapper.CategoryMapper;
import com.demoweb.mapper.NewMapper;
import com.demoweb.model.CategoryModel;
import com.demoweb.model.NewModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		// TODO Auto-generated method stub
		String sql = "select * from category where id = ?";
		List<CategoryModel> categories = query(sql,new CategoryMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "select * from category where code = ?";
		List<CategoryModel> categories = query(sql,new CategoryMapper(), code);
		return categories.isEmpty() ? null : categories.get(0);
	}
	
}
