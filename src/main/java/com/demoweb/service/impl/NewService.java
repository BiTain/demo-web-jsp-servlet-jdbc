package com.demoweb.service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import com.demoweb.dao.ICategoryDAO;
import com.demoweb.dao.INewDAO;
import com.demoweb.model.CategoryModel;
import com.demoweb.model.NewModel;
import com.demoweb.paging.Pageble;
import com.demoweb.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		// TODO Auto-generated method stub
		newModel.setCreatedDate(new Date(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew  = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Date(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		//delete comment
		for(long id : ids) {
			newDAO.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return newDAO.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		// TODO Auto-generated method stub
		NewModel newModel = newDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

}
