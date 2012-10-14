package com.luo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.luo.model.User;

@Repository
public class DaoTemplate {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public void save(User user,String tableName){
		SaveModel model = SqlBuilder.buildSaveSQL(user,tableName);
		jdbcTemplate.update(model.getSql(), model.getArgs());	//insert into t_user(id,username,password)values(?,?,?);
	}
	
	

}
