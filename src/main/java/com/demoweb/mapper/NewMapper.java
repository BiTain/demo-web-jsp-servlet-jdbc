package com.demoweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.demoweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet rs) {
		try {
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreatedDate(rs.getDate("createddate"));
			news.setCreatedBy(rs.getString("createdby"));
			if(rs.getDate("modifieddate") != null) {
				news.setModifiedDate(rs.getDate("modifieddate"));
			}
			if(rs.getString("modifiedby") != null) {
				news.setModifiedBy(rs.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
