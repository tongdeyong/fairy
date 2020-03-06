package com.fairy.system.dao;

import com.fairy.system.model.Role;

import java.util.List;

/**
 * @author deyong_tong
 */
public interface RoleDao {

	/**
	 * 通过id查找角色
	 * @param id id
	 * @return Role
	 */
	Role findById(Integer id);

	/**
	 * 条件查找角色
	 * @param role role
	 * @return list
	 */
	List<Role> findByCondition(Role role);

	/**
	 * 保存角色
	 * @param role  role
	 */
	void save(Role role);

	/**
	 * 更新角色
	 * @param role role
	 * @return int
	 */
	int update(Role role);

	/**
	 * 删除角色
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);

}
