package com.luo.dao;

import java.util.List;

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
	public List<User> findUserList() {
		QueryModel model = new QueryModel();
		model.setSql("select * from t_user");
		model.setTargetClass(User.class);
		model.paramMap.put("id", 1);
		model.paramMap.put("username", "tom");
		List<User> userList = UtilFactory.getDaoTemplate().queryForList(model);
		return userList;
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

	public int queryUsersCount() {
		String sql = "select count(*) from t_user";
		return UtilFactory.getDaoTemplate().queryForInt(sql);
	}

}
