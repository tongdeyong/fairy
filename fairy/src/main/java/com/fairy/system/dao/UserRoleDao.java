package com.fairy.system.dao;

import com.fairy.system.model.UserRole;

import java.util.List;

/**
 * 用户与角色关系
 * @author deyong_tong
 */
public interface UserRoleDao {

	/**
	 * 查找
	 * @param id id
	 * @return UserRole
	 */
	UserRole findById(Integer id);

	/**
	 * 条件查找
	 * @param user user
	 * @return list
	 */
	List<UserRole> findByCondition(UserRole user);

	/**
	 * 保存
	 * @param userRole userRole
	 */
	void save(UserRole userRole);

	/**
	 * 更新
	 * @param userRole userRole
	 * @return int
	 */
	int update(UserRole userRole);

	/**
	 * 删除
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);
}
