package com.luo.db;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.luo.model.User;

public class DaoTemplate {

	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	/** 
	* @Title: save 
	* @Description: 向表中保存数据
	* @param @param object
	* @param @param tableName 
	* @return void
	* @throws 
	*/
	public void save(Object object,String tableName){
		this.jdbcTemplate.execute("insert into t_user(id,username,password)values(2,'tom','123')");
//		SaveModel model = SqlBuilder.buildSaveSQL(object,tableName);
//		System.out.println("SQL执行："+model.getSql());
//		jdbcTemplate.update(model.getSql(), model.getArgs());	//insert into t_user(id,username,password)values(?,?,?);
	}

	/** 
	* @Title: queryForList 
	* @Description: TODO
	* @param @param model
	* @param @return 
	* @return List<User>
	* @throws 
	*/
	public List  queryForList(QueryModel model) {
		List list = jdbcTemplate.queryForList(model.getSql());
		Iterator it = list.iterator();
		while(it.hasNext()) {
		    Map userMap = (Map) it.next();
		    System.out.print(userMap.get("user_id") + "\t");
		    System.out.print(userMap.get("name") + "\t");
		    System.out.print(userMap.get("sex") + "\t");
		    System.out.println(userMap.get("age") + "\t");
		}
		return list;
	}

	/** 
	* @Title: loadObject 
	* @Description: TODO
	* @param @param model
	* @param @return 
	* @return User
	* @throws 
	*/
	public User loadObject(QueryModel model) {
		Map<String, Object> map = model.paramMap;
		String sql = "select * from "+model.getSql()+" where 1=1 ";
		if(map != null){
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				String k = (String) iterator.next();
				sql=sql+"and "+ k + "=" +map.get(k).toString();
			}
		}
		this.jdbcTemplate.q
		return null;
	}
	
	

}
