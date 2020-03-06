package com.fairy.system.dao;

import com.fairy.system.model.UserDept;


/**
 * 用户和部门关联
 * @author deyong_tong
 */
public interface UserDeptDao {

	/**
	 * 通过用户id查找部门
	 * @param userId userId
	 * @return UserDept
	 */
	UserDept findByUserId(Integer userId);

	/**
	 * 保存
	 * @param userDept userDept
	 */
	void save(UserDept userDept);

	/**
	 * 更新
	 * @param userDept userDept
	 */
	void update(UserDept userDept);

	/**
	 * 删除
	 * @param id id
	 */
	void deleteById(Integer id);

	/**
	 * 删除
	 * @param userId userid
	 */
	void deleteByUserId(Integer userId);
}
