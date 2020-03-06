package com.fairy.system.service;

import com.fairy.system.vo.UserVO;
import com.fairy.system.model.User;

import java.util.List;

/**
 * @author deyong_tong
 */
public interface UserService {

	/**
	 * 查询
	 * @param id id
	 * @return User
	 */
	User findById(Integer id);

	/**
	 * 条件查询
	 * @param userVO userVO
	 * @return list
	 */
	List<User> findByCondition(UserVO userVO);

	/**
	 * 保存
	 * @param userVO userVO
	 */
	void save(UserVO userVO);

	/**
	 * 更新
	 * @param userVO userVO
	 */
	void update(UserVO userVO);

	/**
	 * 删除
	 * @param id id
	 */
	void deleteById(Integer id);

	/**
	 * 根据用户名查询
	 * @param username username
	 * @return User
	 */
	User findByUsername(String username);
}
