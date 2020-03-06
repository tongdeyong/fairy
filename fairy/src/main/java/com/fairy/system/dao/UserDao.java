package com.fairy.system.dao;

import com.fairy.system.vo.UserVO;
import com.fairy.system.model.User;

import java.util.List;


/**
 * 用户
 * @author deyong_tong
 */
public interface UserDao {

	/**
	 * 查找
	 * @param id id
	 * @return User
	 */
	User findById(Integer id);

	/**
	 * 条件查找
	 * @param userVO userVO
	 * @return list
	 */
	List<User> findByCondition(UserVO userVO);

	/**
	 * 保存
	 * @param user user
	 */
	void save(User user);

	/**
	 * 更新
	 * @param user user
	 * @return int
	 */
	int update(User user);

	/**
	 * 删除
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);
}
