package com.demoweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.demoweb.dao.ICategoryDAO;
import com.demoweb.model.CategoryModel;
import com.demoweb.service.ICategoryServie;

public class CategoryService implements ICategoryServie{
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

}
