package com.demoweb.dao.impl;

import java.util.List;

import com.demoweb.dao.INewDAO;
import com.demoweb.mapper.NewMapper;
import com.demoweb.model.NewModel;
import com.demoweb.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql,new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("insert into news(title, content, ");
		sql.append("thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" values(? ,? ,? ,? ,? ,? ,?)");
		return insert(sql.toString(), newModel.getTitle(),newModel.getContent(),newModel.getThumbnail(),
				newModel.getShortDescription(),newModel.getCategoryId(),newModel.getCreatedDate(),
				newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewModel> news = query(sql,new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?, ");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?" );
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(),updateNew.getCreatedDate(),updateNew.getCreatedBy(),
				updateNew.getModifiedDate(),updateNew.getModifiedBy(),updateNew.getId()
				);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		String sql = "delete from news where id =?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
//		String sql = "select * from news order by id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		StringBuilder sql = new StringBuilder("select * from news");
		if(pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" order by id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
			return query(sql.toString(),new NewMapper(),pageble.getOffset(),pageble.getLimit());
		}else {
			return query(sql.toString(), new NewMapper());
		}
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}

}
