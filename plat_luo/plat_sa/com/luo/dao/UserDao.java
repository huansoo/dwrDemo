package com.luo.dao;

import org.springframework.stereotype.Repository;
import com.luo.core.UtilFactory;
import com.luo.db.QueryModel;
import com.luo.model.User;

@Repository
public class UserDao {
	
	public void save(User user) {
		UtilFactory.getDaoTemplate().save(user, "t_user");
	}

	/** 
	* @Title: findUserList 
	* @Description: TODO
	* @param @return 
	* @return List<User>
	* @throws 
	*/
	public void findUserList() {
		QueryModel model = new QueryModel();
		model.setSql("insert into t_user(id,username,password)values(1,'tom','123')");
		model.setTargetClass(User.class);
		UtilFactory.getDaoTemplate().queryForList(model);
	}

	/** 
	* @Title: findUserById 
	* @Description: TODO
	* @param @param i
	* @param @return 
	* @return User
	* @throws 
	*/
	public User findUserById(int i) {
		QueryModel model = new QueryModel();
		model.setTableName("t_user");
		model.setTargetClass(User.class);
		model.putParamInMap("id", i);
		User user = UtilFactory.getDaoTemplate().loadObject(model);
		return user;
	}

}
