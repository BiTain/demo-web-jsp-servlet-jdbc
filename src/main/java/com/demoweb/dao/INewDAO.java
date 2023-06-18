package com.demoweb.dao;

import java.util.List;

import com.demoweb.model.NewModel;
import com.demoweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel>{
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
